package categoryAandB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Trace {

    public static void main(String[] args) {
	InputReader in = new InputReader(System.in);
	OutputWriter out = new OutputWriter(System.out);
	int n = in.readInt();
	int[] arr = new int[n];
	final double PIE = 3.1415926536;
	for (int i = 0; i < n; i++) {
	    arr[i] = in.readInt();
	}
	Arrays.sort(arr);
	int sum = 0;
	for (int i = 0; i < n; i++) {
	    int mul = (int) Math.pow(arr[i], 2);
	    if (i % 2 == 0)
		sum -= mul;
	    else
		sum += mul;
	}

	out.print(Math.abs(PIE * sum));
	out.close();
    }

    static class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
	    this.stream = stream;
	}

	public int read() {
	    if (numChars == -1)
		throw new InputMismatchException();
	    if (curChar >= numChars) {
		curChar = 0;
		try {
		    numChars = stream.read(buf);
		} catch (IOException e) {
		    throw new InputMismatchException();
		}
		if (numChars <= 0)
		    return -1;
	    }
	    return buf[curChar++];
	}

	public String readLine() {
	    int c = read();
	    while (isSpaceChar(c))
		c = read();
	    StringBuilder res = new StringBuilder();
	    do {
		res.appendCodePoint(c);
		c = read();
	    } while (!isEndOfLine(c));
	    return res.toString();
	}

	public String readString() {
	    int c = read();
	    while (isSpaceChar(c))
		c = read();
	    StringBuilder res = new StringBuilder();
	    do {
		res.appendCodePoint(c);
		c = read();
	    } while (!isSpaceChar(c));
	    return res.toString();
	}

	public long readLong() {
	    int c = read();
	    while (isSpaceChar(c))
		c = read();
	    int sgn = 1;
	    if (c == '-') {
		sgn = -1;
		c = read();
	    }
	    long res = 0;
	    do {
		if (c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = read();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}

	public int readInt() {
	    int c = read();
	    while (isSpaceChar(c))
		c = read();
	    int sgn = 1;
	    if (c == '-') {
		sgn = -1;
		c = read();
	    }
	    int res = 0;
	    do {
		if (c < '0' || c > '9')
		    throw new InputMismatchException();
		res *= 10;
		res += c - '0';
		c = read();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}

	public boolean isSpaceChar(int c) {
	    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public boolean isEndOfLine(int c) {
	    return c == '\n' || c == '\r' || c == -1;
	}
    }

    static class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
	    writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
		    outputStream)));
	}

	public OutputWriter(Writer writer) {
	    this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
	    for (int i = 0; i < objects.length; i++) {
		if (i != 0)
		    writer.print(' ');
		writer.print(objects[i]);
	    }
	}

	public void printLine(Object... objects) {
	    print(objects);
	    writer.println();
	}

	public void close() {
	    writer.close();
	}
    }

}