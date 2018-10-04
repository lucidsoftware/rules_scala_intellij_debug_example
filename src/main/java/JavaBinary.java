package foo;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;

public class JavaBinary {
	public static void main(String[] arg) {
		System.out.println("Hello world");

		try {
			final PipedOutputStream out = new PipedOutputStream();
	      	final PipedInputStream in = new PipedInputStream(out);

			MultiplexWorker mw = new MultiplexWorker(in, "MW");
			mw.start();

			ProxyWorker pw0 = new ProxyWorker(out, "A", 0);
			pw0.start();
			ProxyWorker pw1 = new ProxyWorker(out, "B", 1);
			pw1.start();
			ProxyWorker pw2 = new ProxyWorker(out, "C", 2);
			pw2.start();

		} catch (IOException x) {
	      x.printStackTrace();
	    }
	}
}