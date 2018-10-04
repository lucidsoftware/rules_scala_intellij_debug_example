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
	private static Semaphore sem = new Semaphore(1);
	private Socket socket;

	public ProxyWorker(Socket socket, String threadName, int id) {
		super(threadName);
		this.threadName = threadName;
		this.id = id;
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			sem.acquire();

			ObjectOutputStream objectOut = new ObjectOutputStream(socket.getOutputStream());
			objectOut.writeObject(id);

			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			int temp = (int) in.readObject();
            System.out.println(temp);

            sem.release();
		} catch (InterruptedException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}