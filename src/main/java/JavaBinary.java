package foo;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

public class JavaBinary {
	public static void main(String[] arg) {
		System.out.println("Hello world");

		try {
			ServerSocket serverSock = new ServerSocket(9999);
			Socket socket = new Socket("localhost", 9999);

			MultiplexWorker mw = new MultiplexWorker(serverSock, "MW");
			mw.start();

			ProxyWorker pw0 = new ProxyWorker(socket, "A", 0);
			pw0.start();
			ProxyWorker pw1 = new ProxyWorker(socket, "B", 1);
			pw1.start();
			ProxyWorker pw2 = new ProxyWorker(socket, "C", 2);
			pw2.start();

		} catch (IOException x) {
	      x.printStackTrace();
	    }
	}
}