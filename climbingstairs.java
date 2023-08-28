class climbingstairs {
    public int climbStairs(int n) 
    {
        int dp[] = new int[n+1];
        // return memo(n,dp);
        return tabway(n,dp);
    }
    // dp way
    public int memo(int n , int dp[])
    {
        if(n==0 || n==1) return 1;

        //if the index have value means return it
        if(dp[n]!=0) return dp[n];

        int f = memo(n-1,dp);
        int s = memo(n-2,dp);
        dp[n] = f + s;
        return f + s;
    }

    //tabulation way
    public int tabway(int n , int dp[])
    {
        for(int i = 0 ; i<=n ; i++)
        {
            if(i==0 || i==1)
            {
                dp[i] = 1;
                continue;
            }

            int f = dp[i-1];
            int s = dp[i-2];
            dp[i] = f + s;
        }
        return dp[n];
    }
}