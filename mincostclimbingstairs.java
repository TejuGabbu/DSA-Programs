class Solution 
{
    public int recur(int cost[] , int i)
    {
        if(i==cost.length) return 0;
        if(i>cost.length) return Integer.MAX_VALUE;

        int f = recur(cost , i+1);
        int s = recur(cost , i+2);
        int min = Math.min(f,s);
        return min + cost[i];
    }

    // memoization method dynamic programming
    public int memo(int cost[] , int i , int dp[])
    {
        if(i==cost.length) return 0;
        if(i>cost.length) return Integer.MAX_VALUE;

        if(dp[i]!=0) return dp[i];

        int f = memo(cost , i+1 , dp);
        int s = memo(cost , i+2 , dp);
        int min = Math.min(f,s);
        dp[i] = min + cost[i];
        return min + cost[i];
    }
    public int minCostClimbingStairs(int[] cost) 
    {
        int dp[] = new int[cost.length+1];
        int zero = memo(cost , 0 , dp);
        int first = memo(cost , 1,dp);
        return Math.min(zero , first);
        
        // return Math.min(zero , first);
    }
}