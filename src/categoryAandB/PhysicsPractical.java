package categoryAandB;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PhysicsPractical
{
    public static void main(String[] args) throws FileNotFoundException {
		/*Scanner fin = new Scanner(new File("input.txt"));
		PrintStream fout = new PrintStream("output.txt");*/
	Scanner fin = new Scanner(System.in);

	int n = fin.nextInt();
	int[] arr = new int[n];
	for (int i = 0; i < n; i++) {
	    arr[i] = fin.nextInt();
	}
	Arrays.sort(arr);
	int len = arr.length;
	int min, x, pos, d;
	if (len == 2) {
	    if (2 * (arr[0]) >= arr[len - 1]) {
		min = 0;
	    } else {
		min = 1;
	    }
	} else {
	    min = len;
	    Set<Integer> unique = new HashSet<Integer>();
	    for (int i = 0; i < n - 2; i++) {
		x = 2 * arr[i];
		if (unique.add(x)) {
		    pos = binarySearch(arr, x, len);
		    d = len - 1 - pos + i;
		    min = Math.min(min, d);
		}
	    }
	}
	System.out.println(min);
		/*fout.print(min);
		fout.close();
		fin.close();*/
	}

    static int binarySearch(int[] arr, int num, int len) {
	int low = 0;
	int high = len;
	int mid = 0;
	while (low < high) {
	    mid = (low + high) / 2;
	    if (arr[mid] == num) {
		while (mid < len && arr[mid] == num) {
		    mid++;
		}
		return mid - 1;
	    } else if (num > arr[mid]) {
		low = mid + 1;
	    } else {
		high = mid;
	    }
	}
	if (arr[mid] > num)
	    return mid - 1;
	else
	    return mid;
    }
}
