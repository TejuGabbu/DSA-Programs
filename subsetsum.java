import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int sum = Integer.parseInt(line[1]);
        int[] arr = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Solution sol = new Solution();
        Boolean ans = sol.subsetSum(arr, n, sum);
        if(ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

class Solution 
{
	public boolean memo(int arr[] , int i , int sum, int dp[][])
	{
		if(sum==0) return true;
		if(sum<0) return false;
		if(i==arr.length) return false;

		if(dp[i][sum]!=0) return dp[i][sum]==1;
		boolean come = memo(arr , i+1 , sum - arr[i],dp);
		boolean not = memo(arr , i+1 , sum , dp);
		dp[i][sum] = come || not ? 1 : -1 ;
		return come ||  not;
	}
    public boolean subsetSum(int[] arr, int n, int sum) 
	{
		int dp[][] = new int[n+1][sum+1];
		return memo(arr , 0 , sum,dp);
    }
}