import java.util.*;

class Solution 
{
	public int find(int presum[] , int l , int r)
	{
		if(l==0)
		{
			return presum[r];
		}
		return presum[r] - presum[l-1];
	}
    public int[] sumQuery(int[] arr, int[][] ranges) 
	{
        // Your code here.
		int presum[] = new int[arr.length];
		presum[0] = arr[0];
		for(int i = 1 ; i<arr.length ; i++)
			{
				presum[i] = arr[i] + presum[i-1];
			}

		int tej[] = new int[ranges.length]; // 3 queries so length is 3
		for(int i = 0 ; i<ranges.length ; i++)
			{
				int l = ranges[i][0];
				int r = ranges[i][1]; 
				int result = find(presum , l , r);
				tej[i] = result;
			}
		return tej;
    }
}

public class RangeSumQuery 
{
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}