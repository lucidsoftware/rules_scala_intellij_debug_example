package foo;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.*;

public class MultiplexWorker {
	private PipedOutputStream out;
	private PipedInputStream in;
	private String name;
	private static Map<String, MultiplexWorker> instanceMap = new HashMap<>();

	public MultiplexWorker(String name) {
		try {
			this.out = new PipedOutputStream();
			this.in = new PipedInputStream(out);
		} catch (IOException e) {
	      e.printStackTrace();
	    }
	    this.name = name;
	}

	public String getName() {
		System.out.println(instanceMap);
		return name;
	}

	public static MultiplexWorker getInstance(String name) {
        if (!instanceMap.containsKey(name)) {
            instanceMap.put(name, new MultiplexWorker(name));
        }
        return instanceMap.get(name);
    }

	public void print() {
		try {
			System.out.println(in.read());
		} catch (IOException e) {
	      e.printStackTrace();
	    }
	}

	public OutputStream getOutputStream() {
		return out;
	}
}