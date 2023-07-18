import java.util.Scanner;

class Solution
{
    static int findLengthOfSmallestSubarray(int[] a, int k) 
	{
        //Write your code here
		int si = 0;
		int ei = 0;
		int n = a.length;
		int ans = Integer.MAX_VALUE;;
		int sum = 0;
		while(ei<n)
			{
				sum = sum + a[ei];
				while(sum>=k)
					{
						int len = (ei - si)+1;
						ans = Math.min(ans , len);
						sum = sum - a[si];
						si++;
					}
				ei++;
			}
		return ans;
    }
}
public class MinimumSizeSubarraySum
{ 
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
		int K = keyboard.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = keyboard.nextInt();
        }
        keyboard.close();
        System.out.println(Solution.findLengthOfSmallestSubarray(a, K));
    }
} 	