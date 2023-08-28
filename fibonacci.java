class fibonacci 
{
    public int fib(int n) 
    {
        int dp[] = new int[n+1];
        return memo(n,dp);
    }
    public int memo(int n , int dp[])
    {
        if(n==0) return 0;
        if(n==1) return 1;

        // here means we have the answer 
        if(dp[n]!=0) return dp[n];

        int f = memo(n-1,dp);
        int s = memo(n-2,dp);
        dp[n] = f + s;
        return f+s;
    }
}