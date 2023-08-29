class Solution {
    public int recur(int nums[] , int i , int dp[])
    {
        if(i>=nums.length) return 0;

        if(dp[i]!=-1) return dp[i];
        int inc = nums[i] + recur(nums , i+2,dp);
        int exc = recur(nums , i+1,dp);
        dp[i] = Math.max(inc , exc);
        return Math.max(inc ,exc);
    }
    public int rob(int[] nums) {
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return recur(nums , 0 , dp);
    }
}