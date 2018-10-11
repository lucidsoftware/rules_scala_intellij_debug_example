package foo;

public class JavaBinary {
	public static void main(String[] arg) {
		// MultiplexWorker mw = new MultiplexWorker();

		// ProxyWorker pw = new ProxyWorker();

		// pw.write(mw.getOutputStream());

		// mw.print();

		MultiplexWorker mw0 = MultiplexWorker.getInstance("Javac");
		System.out.println(mw0.getName());

		MultiplexWorker mw1 = MultiplexWorker.getInstance("Javac");
		System.out.println(mw1.getName());

		MultiplexWorker mw2 = MultiplexWorker.getInstance("ScalaCompile");
		System.out.println(mw2.getName());

		MultiplexWorker mw3 = MultiplexWorker.getInstance("Javac");
		System.out.println(mw3.getName());
	}
}