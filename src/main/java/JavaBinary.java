package foo;

// import java.io.PipedInputStream;
// import java.io.PipedOutputStream;

public class JavaBinary {
	public static void main(String[] arg) {
		System.out.println("Hello world");

		// final PipedOutputStream out = new PipedOutputStream();
  //     	final PipedInputStream in = new PipedInputStream(out);

		MultiplexWorker mw = new MultiplexWorker("MW");
		mw.start();

		ProxyWorker pw0 = new ProxyWorker("A", 0);
		pw0.start();
		ProxyWorker pw1 = new ProxyWorker("B", 1);
		pw1.start();
		ProxyWorker pw2 = new ProxyWorker("C", 2);
		pw2.start();
	}
}