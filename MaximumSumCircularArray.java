import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) 
	{
        // Write your code here
		int max = Integer.MIN_VALUE;
		int maxtrain = 0;

		int min = Integer.MAX_VALUE;
		int mintrain = 0;

		int total = 0;
		for(int i = 0; i<n ; i++)
			{
				total+=arr[i];

				maxtrain = Math.max(arr[i] , maxtrain+arr[i]);
				max = Math.max(max , maxtrain);

				mintrain = Math.min(arr[i] , mintrain+arr[i]);
				min = Math.min(min , mintrain);

			}

		if(total==min)
		{
			return max;
		}
		return Math.max(max, total-min);
			

    }
}

public class MaximumSumCircularArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
	    Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}