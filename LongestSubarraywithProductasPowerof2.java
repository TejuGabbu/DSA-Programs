import java.util.*;

class Solution{
	
public static boolean isPower(int x)
{
	if (x != 0 && (x & (x - 1)) == 0)
		return true;
		
	return false;
}

public static void maximumlength(int arr[], int N)
{
	int max_length = 0;
	int max_len_subarray = 0;
	for(int i = 0; i < N; i++)
	{
		if (isPower(arr[i]))
		{
			max_length++;
			max_len_subarray = Math.max(max_length, max_len_subarray);
		}
		else
		{
			max_length = 0;
		}
	}
	System.out.println(max_len_subarray);
}
}

public class LongestSubarraywithProductasPowerof2
{
    public static void main(String args[])
{
	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Solution.maximumlength(array, n);
}
}
