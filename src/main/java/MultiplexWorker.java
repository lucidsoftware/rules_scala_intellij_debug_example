package foo;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.EOFException;
import java.io.IOException;

public class MultiplexWorker extends Thread {
	private DataInputStream in;

	public MultiplexWorker(InputStream rawIn, String threadName) {
		super(threadName);
		this.in = new DataInputStream(new BufferedInputStream(rawIn));
	}

	@Override
	public void run() {
		try {
			boolean eof = false;
			while (!eof) {
				try {
					int i = in.readInt();
					System.out.println("just read: " + i);
				} catch (EOFException eofx) {
					eof = true;
				}
			}
		} catch (IOException x) {
	    	x.printStackTrace();
	    }
	}
}