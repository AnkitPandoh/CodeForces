package categoryAandB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class VasyaAndWrestling {

    public static void main(String[] args) {
	InputReader in = new InputReader(System.in);
	OutputWriter out = new OutputWriter(System.out);
	int[] arr1 = new int[200000];
	int[] arr2 = new int[200000];
	int n = in.readInt();
	long sum1 = 0, sum2 = 0;
	String ans = null;
	int k = 0, j = 0;
	for (int i = 0; i < n; i++) {
	    int point = in.readInt();
	    if (point > 0) {
		sum1 += point;
		ans = "first";
		arr1[k++] = point;
	    } else {
		int p = Math.abs(point);
		sum2 += p;
		ans = "second";
		arr2[j++] = p;
	    }
	}
	if (sum1 > sum2) {
	    out.print("first");
	} else if (sum1 < sum2) {
	    out.print("second");
	} else {
	    k = 0;
	    j = 0;
	    while (arr1[k] != 0 && arr2[j] != 0) {
		if (arr1[k] > arr2[j]) {
		    ans = "first";
		    break;
		} else if (arr1[k] < arr2[j]) {
		    ans = "second";
		    break;
		} else {
		    k++;
		    j++;
		}
	    }
	    out.print(ans);
	}
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
