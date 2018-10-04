package foo;

import java.util.concurrent.*;
import java.util.Arrays;

public class ProxyWorker extends Thread {
	private static int[] intArray = new int[]{0, 0, 0};
	private final String threadName;
	private final int id;
	private static Semaphore sem = new Semaphore(1);

	public ProxyWorker(String threadName, int id) {
		super(threadName);
		this.threadName = threadName;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			try {
				
				for (int i = 0; i < 5; i++) {
					sem.acquire();
					System.out.println(id + " is working");
					intArray[id] += 1;
					System.out.println(Arrays.toString(intArray));

					sem.release();
				}
			} finally {
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}