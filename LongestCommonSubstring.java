import java.util.*;

class Main {
    public static void main (String[] args) {

        Scanner sc=new Scanner(System.in);
        
        int p=sc.nextInt();             // Take size of both the strings as input
        int q=sc.nextInt();
        
        String a=sc.next();            // Take both the string as input
        String b=sc.next();
        
        Solution obj = new Solution();
        
        System.out.println(obj.lcs(p, q, a, b));

        sc.close();
    
    }
}


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String a, String b)
    {
        // your code here 
		int dp[][] = new int[x+1][y+1];
		for(int i = x-1 ; i>=0 ; i--)
			{
				for(int j = y-1 ; j>=0 ; j--)
					{
						if(a.charAt(i)==b.charAt(j)) dp[i][j] = dp[i+1][j+1] + 1;
					}
			}

		int max = 0;
		for(int i = x-1 ; i>=0 ; i--)
			{
				for(int j = y-1 ; j>=0 ; j--)
					{
						max = Math.max(dp[i][j] , max);
					}
			}
		return max;
    }
    
}