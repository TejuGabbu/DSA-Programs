import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
    
    public static boolean isMatch(String s, String p) 
	{
        //write your code here 
		int n = s.length();
		int m = p.length();
		int dp[][] = new int[n+1][m+1];
		return recur(s , p , 0 , 0 , dp);
    }
	public static boolean recur(String s , String p , int i , int j , int dp[][])
	{
		if(i==s.length() && j==p.length()) return true;

		if(i!=s.length() && j==p.length()) return false;

		if(dp[i][j]!=0)
		{
			if(dp[i][j]==1) return true;
			return false;
		}
		if(i==s.length() && j!=p.length())
		{
			if(p.charAt(j)!='*') return false;
			dp[i][j] = recur(s , p , i , j+1 , dp) ? 1 : -1; // star as empty
			return dp[i][j]==1;
		}

		if(p.charAt(j)=='?') 
		{
			dp[i][j] =  recur(s , p , i+1  , j+1 , dp) ? 1 : -1;
			return dp[i][j] ==  1;
		}
		else if(p.charAt(j)=='*') 
		{
			boolean empty = recur(s , p , i , j+1 , dp);
			boolean not = recur(s , p , i+1 , j , dp);
			dp[i][j] = empty || not ? 1 : -1;
			return dp[i][j] == 1; 
		}

		if(s.charAt(i)!=p.charAt(j))
		{
			return false;
		}
		else 
		{
			dp[i][j] = recur(s , p , i+1 , j+1 , dp) ? 1 : -1;
			return dp[i][j] ==1;
		}
	}
}
/* Name of the class has to be "Main" only if the class is public. */
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        String pattern = sc.next();
        System.out.print(Solution.isMatch(text,pattern));
	}
}

