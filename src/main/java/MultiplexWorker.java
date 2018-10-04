package foo;

public class MultiplexWorker extends Thread {
	public MultiplexWorker(String threadName) {
		super(threadName);
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
}