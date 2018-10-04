package foo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.Arrays;
import java.util.Date;

public class ProxyWorker extends Thread {
	private final String threadName;
	private final int id;
	// private static Semaphore sem = new Semaphore(1);

	public ProxyWorker(String threadName, int id) {
		super(threadName);
		this.threadName = threadName;
		this.id = id;
	}

	@Override
	public void run() {
		try {
			// sem.acquire();

			Socket socket = new Socket("localhost", 9999);

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(id);
			out.flush();

			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			int temp = (int) in.readObject();
            System.out.println("just returned: " + temp);
            socket.close();

            // sem.release();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}