package categoryAandB;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PashmakAndFlowers
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] nums = br.readLine().split(" ");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = Integer.parseInt(nums[i]);
		}
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < n; i++)
		{
			if (max < arr[i])
				max = arr[i];
			if (min > arr[i])
				min = arr[i];
		}
		int d = max - min;
		long result = 0;
		if(d==0){
			result =(long) n*(n-1)/2;
		}else{
			long countMax = 0;
			long countMin = 0;
			for (int i = 0; i < n; i++)
			{
				if (arr[i] == max)
					countMax++;
				if (arr[i] == min)
					countMin++;
			}
			result = countMax * countMin;
		}
		System.out.print(d +" "+result);
	}
}
