package foo;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.Arrays;

public class ProxyWorker extends Thread {
	private final String threadName;
	private final int id;
	private static Semaphore semWrite = new Semaphore(1);
	private static Semaphore semClose = new Semaphore(1);
	private static int done = 0;
	private DataOutputStream out;

	public ProxyWorker(OutputStream rawOut, String threadName, int id) {
		super(threadName);
		this.threadName = threadName;
		this.id = id;
		this.out = new DataOutputStream(new BufferedOutputStream(rawOut));
	}

	@Override
	public void run() {
		try {
			try {
				for (int i = 0; i < 5; i++) {
					semWrite.acquire();
					out.writeInt(id);
					out.flush();
					// System.out.println(Arrays.toString(intArray));
					semWrite.release();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			semClose.acquire();
			done += 1;
			if (done == 3) {
				try {
	  				out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			semClose.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}