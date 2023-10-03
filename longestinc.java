class Solution {
    public int lengthOfLIS(int[] a) {
        int size = a.length;
        int dp[][] = new int[size+1][size+1];
        return recur(a , size-1 , size , dp);
    }
    public  int recur(int a[] ,int ind , int next , int dp[][])
    {
        if(ind<0) return 0;
        if(dp[ind][next]!=0) return dp[ind][next];
        
        int exc = recur(a , ind-1 , next,dp);
        
        int inc = 0;
        
        if(next==a.length || a[ind]<a[next])
        {
            inc = recur(a , ind-1 , ind , dp) + 1;
        }
        
        return dp[ind][next]= Math.max(exc , inc);
    }
}