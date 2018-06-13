package categoryAandB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class SuffixStructures {

    public static void main(String[] args) {

	InputReader in = new InputReader(System.in);
	OutputWriter out = new OutputWriter(System.out);
	String s = in.readString();
	String t = in.readString();
	int slen = s.length();
	int tlen = t.length();
	int[] sarr = new int[26];
	int[] tarr = new int[26];

	for (int i = 0; i < slen; i++) {
	    sarr[s.charAt(i) - 'a']++;
	}
	for (int i = 0; i < tlen; i++) {
	    tarr[t.charAt(i) - 'a']++;
	}
	if (slen != tlen) {
	    boolean isAutomaton = true;
	    boolean needTree = true;
	    for (int i = 0; i < slen; i++) {
		if (sarr[s.charAt(i) - 'a'] < tarr[s.charAt(i) - 'a']) {
		    isAutomaton = false;
		    break;
		}
		if (needTree) {
		    if (sarr[s.charAt(i) - 'a'] != 0
			    && tarr[s.charAt(i) - 'a'] == 0) {
			needTree = true;
		    } else {
			needTree = false;
		    }
		}
	    }
	    if (isAutomaton && !needTree) {
		if (isSubsequence(s, t)) {
		    out.print("automaton");
		} else {
		    out.print("both");
		}
	    } else {
		out.print("need tree");
	    }
	} else {
	    boolean isArray = true;
	    for (int i = 0; i < tarr.length; i++) {
		if (tarr[i] > sarr[i] || tarr[i] < sarr[i]) {
		    isArray = false;
		    break;
		}
	    }
	    if (isArray) {
		out.print("array");
	    } else {
		out.print("need tree");
	    }
	}
	out.close();
    }

    private static boolean isSubsequence(String s, String t) {
	boolean isSub = false;
	int j = 0;
	for (int i = 0; i < s.length() && j < t.length(); i++) {
	    if (s.charAt(i) == t.charAt(j)) {
		j++;
	    }
	}
	if (j == t.length()) {
	    isSub = true;
	}
	return isSub;
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