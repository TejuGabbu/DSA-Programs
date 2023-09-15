//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfWays(N));
        }
    }
}
// } Driver Code Ends


class Solution {
    static long memo(int n ,long dp[])
    {
        if(n==1) return 1;
        if(n==2) return 2;
        
        if(dp[n]!=-1) return dp[n];
        long md = 1000000007;
        
        long v = memo(n-1 , dp);
        long h = memo(n-2,dp);
        return dp[n] = (v + h)%md;
    }
    static Long numberOfWays(int N) 
    {
        // code here
        long dp[] = new long[N+1];
        Arrays.fill(dp, -1);
        long md = 1000000007;
        return memo(N , dp)%md;
    }
};