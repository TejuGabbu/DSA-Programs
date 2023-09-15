//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long countFriendsPairings(int n) 
    { 
       //code here
       long dp[] = new long[n+1];
       Arrays.fill(dp , -1);
               long md = 1000000007;

       return recur(n , dp)%md;
    }
    public long recur(int n , long dp[])
    {
        if(n==1) return 1;
        if(n==2) return 2;
        long md = 1000000007;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = (recur(n-1 , dp) + ((n-1)*recur(n-2 , dp))%md)%md;
    }
}    
 S