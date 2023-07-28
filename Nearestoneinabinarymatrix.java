import java.util.*;
import java.lang.*;
import java.io.*;
class Nearestoneinabinarymatrix
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}
class Solution
{
	public class pair
		{
			int x ;
			int y ;
			pair(int x , int y)
			{
				this.x = x;
				this.y = y;
			}
		}
	public boolean valid(int x, int y , int n , int m)
	{
		if(x<0 || y<0 || x>=n || y>=m) return false;
		return true;
			
	}
    public int[][] nearest(int[][] a)
    {
		int n = a.length;
		int m = a[0].length;
		int ans[][] = new int[n][m];
		for(int i = 0 ; i<n ; i++)		
			{
				for(int j = 0 ; j<m ;j++)
					{
						ans[i][j] = Integer.MAX_VALUE;
					}
			}

		Queue<pair> q = new ArrayDeque<>();
		for(int i = 0 ; i<n ; i++)		
			{
				for(int j = 0 ; j<m ;j++)
					{
						if(a[i][j]==1)
						{
							ans[i][j] = 0;
							q.add(new pair(i,j));
						}
					}
			}
		
		int dx[] =  {0 , - 1 , 0 , 1 };
		int dy[] =  {1 , 0 , -1 , 0 };
		while(q.size()!=0)
			{
				pair re = q.remove();
				int f = re.x;
				int s = re.y;

				for(int i = 0 ; i<4 ; i++)
					{
						int nx = f + dx[i];
						int ny = s + dy[i];

						if(valid(nx , ny , n ,m) && ans[nx][ny]>ans[f][s]+1)
						{
							ans[nx][ny] = ans[f][s] + 1;
							q.add(new pair(nx , ny));
						}
					}
			}
		return ans;
       
    }
}