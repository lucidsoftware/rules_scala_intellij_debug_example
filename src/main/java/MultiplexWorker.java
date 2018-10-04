package foo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStream;
import java.io.EOFException;
import java.io.IOException;

public class MultiplexWorker extends Thread {
	private ServerSocket serverSock;

	public MultiplexWorker(ServerSocket serverSock, String threadName) {
		super(threadName);
		this.serverSock = serverSock;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSock.accept();
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
				int receivedObject = (int) in.readObject();
				System.out.println("just read: " + receivedObject);

				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				out.writeObject(receivedObject + 100);
				out.flush();

			} catch (ClassNotFoundException | IOException x) {
		    	x.printStackTrace();
		    }
		}
	}
}