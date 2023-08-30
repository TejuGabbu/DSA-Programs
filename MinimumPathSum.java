import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution 
{
	public static int min(int a[][] , int sr , int sc , int dr , int dc, int dp[][])
	{
		if (sr>dr ||  sc>dc) return Integer.MAX_VALUE;
		if(sr==dr && sc==dc) return a[sr][sc];

		if(dp[sr][sc]!=-1) return dp[sr][sc];
		
		int right =   min(a,sr , sc+1 , dr , dc,dp);
		int down  =  min(a,sr+1 , sc , dr , dc,dp);

		int min = Math.min(right , down) +  a[sr][sc];
		dp[sr][sc] = min;
		return min;
	}
	public static int minPathSum(int[][] input) 
	{
		//Your code goes here
		int n = input.length;
		int m = input[0].length;
		int dp[][] = new int[n][m];
		for(int i = 0 ; i<dp.length ;i++ )
			{
				Arrays.fill(dp[i],-1);
			}
		return min(input , 0 , 0 ,n-1 , m-1 , dp);
	}
}
public class MinimumPathSum
 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(Solution.minPathSum(mat));
    }
}