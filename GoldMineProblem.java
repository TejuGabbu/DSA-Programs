//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GoldMineProblem
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} 
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int memo(int arr[][] , int sr , int sc , int dp[][])
    {
        int n = arr.length;
        int m = arr[0].length;
        
        if(sr<0 ||  sc>=m || sr>=n) return 0;
        
        
        if(dp[sr][sc]!=-1) return dp[sr][sc];
        
        int diaup = memo(arr , sr-1 , sc+1 , dp);
        int right = memo(arr , sr , sc+1 , dp);
        int diadown = memo(arr , sr+1 , sc +1 , dp);
        
        int min = Math.max(right , Math.max(diaup , diadown)) + arr[sr][sc];
        dp[sr][sc] = min;
        return min;
    }
    static int maxGold(int n, int m, int arr[][])
    {
        // code here
        int dp[][] = new int[n][m];
        for(int i = 0 ; i<n ; i++)
        {
            Arrays.fill(dp[i] , -1);
        }
        int maxi = 0;
        for(int i = 0 ; i<n ; i++)
        {
            int row = memo(arr , i , 0 , dp);
            maxi = Math.max(row , maxi);
                  
        }
        return maxi;
    }
}