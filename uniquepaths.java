import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- != 0) {
      int r = sc.nextInt(), c = sc.nextInt();
      System.out.println(uniquePaths(r, c));
    }
    sc.close();
  }

  public static int uniquePaths(int n, int m) 
	{
    // your code here
		int dp[][] = new int[n][m];
				for(int i = 0 ; i<n ; i++)
					{
						Arrays.fill(dp[i] , -1);
					}
		return countMazePath(0,0 , n-1 , m-1 , dp);
		
	}
	static int countMazePath(int sr , int sc, int n, int m , int dp[][]) //2 2 
			{  
				if(sr>n || sc>m)
				{
					return 0;
				}
				if (sr == n && sc == m)
				{
					return 1; 
				}
				if(dp[sr][sc]!=-1) return dp[sr][sc];
				int right = countMazePath(sr,sc+1,n,m,dp);
				int down = countMazePath(sr+1,sc,n,m,dp);
				return	dp[sr][sc] = right + down;
		
			} 
}