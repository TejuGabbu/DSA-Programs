import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static boolean memo(String s , int sp , int ep , int dp[][])
	{
		if(sp==ep) return true;
		if(sp>ep) return true;
		if(s.charAt(sp)!=s.charAt(ep)) return false;
		if(dp[sp][ep]!=0) return dp[sp][ep] == 1;

		dp[sp][ep] = memo(s , sp+1 , ep-1 , dp) ? 1 : -1;
		return dp[sp][ep]==1;
		
	}
    public static int countSubstrings(String s) 
	{
        //Write your code here 
		int ct = 0;
		int n = s.length();
		int dp[][] = new int[n][n];
		for(int i = 0 ;i<n; i++)
			{
				for(int j = i; j<n ; j++)
					{
						boolean ispali = memo(s , i , j , dp);
						if(ispali) ct++;
					}
			}
		return ct;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(Solution.countSubstrings(str));
	}
}

