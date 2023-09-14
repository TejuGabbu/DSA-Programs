import java.util.*;
class Accio 
{
    public static int knapSack(int n, int W, int[] wt, int[] val)
	{
        //Write your code here
		int dp[][] = new int[n][W+1];
         for(int i = 0 ; i<n ; i++)
         {
             Arrays.fill(dp[i] , -1);
         }
         return memo(wt , val , 0 , W, dp);
    }
	public static int memo(int wt[] , int val[] , int i , int w , int dp[][])
    {
        if(w<0) return Integer.MIN_VALUE;
        if(w==0 || i==wt.length) return 0;
        if(dp[i][w]!=-1) return dp[i][w];
        
        int take = memo(wt , val , i+1 , w - wt[i],dp) + val[i];
        int not = memo(wt , val , i+1 , w,dp);
        return dp[i][w] = Math.max(take , not);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, W;
        n = sc.nextInt();
        W = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++)
            wt[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            val[i] = sc.nextInt();
        Accio Obj = new Accio();
        int result = Obj.knapSack(n, W, wt, val);
        System.out.println(result);
        sc.close();
    }
}