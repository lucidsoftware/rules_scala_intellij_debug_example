package foo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ProxyWorker {

	public ProxyWorker() {
	}

	public void write(OutputStream out) {
		int content = 14;
		try {
			out.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}