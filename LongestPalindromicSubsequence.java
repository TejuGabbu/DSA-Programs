import java.util.*;

class Accio {
    static int recur(String s , int sp , int ep , int dp[][])
	{
		if(sp==ep) return 1;
		if(sp+1==ep) 
		{
			if(s.charAt(sp)==s.charAt(ep)) return 2;
			return 1;
		}

		if(s.charAt(sp)==s.charAt(ep))
		{
			return recur(s , sp+1 , ep-1 , dp) + 2;
		}

		if(dp[sp][ep]!=0) return dp[sp][ep];

		int first = recur(s , sp , ep-1 , dp);
		int second = recur(s , sp+1 , ep , dp);
		return  dp[sp][ep] = Math.max(first , second);
	}
    static int longestPalindromeSubsequence(String s) {
        //Write you code her
		int n = s.length();
		int dp[][] = new int[n][n];
		return recur(s , 0 , n-1 , dp);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Accio ob = new Accio();
        System.out.println(ob.longestPalindromeSubsequence(s));
    }
}
