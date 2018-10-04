package foo;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.Arrays;

public class Ghost extends Thread {
	private final String threadName;
	private final int id;
	private DataOutputStream out;

	public Ghost(OutputStream rawOut, String threadName, int id) {
		super(threadName);
		this.threadName = threadName;
		this.id = id;
		this.out = new DataOutputStream(new BufferedOutputStream(rawOut));
	}

	@Override
	public void run() {
		try {
			out.writeInt(id);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}