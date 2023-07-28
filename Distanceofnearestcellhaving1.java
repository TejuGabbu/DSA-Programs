import java.util.*;
import java.lang.*;
import java.io.*;

public class Distanceofnearestcellhaving1
{
	public static class pair
	{
		int x;
		int y;

		pair(int x , int y)
			{
				this.x = x;
				this.y = y;
			}
	}
	public static boolean valid(int a , int b , int n , int m)
	{
		if(a<0 || b<0 || a>=n || b>=m ) return false;
		return true;
	}
    public static int[][] nearest(int[][] a)
    {
		int n = a.length;
		int m = a[0].length;
		Queue<pair> q = new ArrayDeque<>();
		int ans[][] = new int[n][m];
		
		int dx[] = {1 , - 1 , 0 , 0};
		int dy[] = {0 , 0 , 1 , -1};

		for(int i = 0 ; i<n ; i++)
			{
				for(int j = 0 ; j<m ; j++)
					{
						ans[i][j]=Integer.MAX_VALUE;
					}
			}
		
		for(int i = 0 ; i<n ; i++)
			{
				for(int j = 0 ; j<m ; j++)
					{
						if(a[i][j]==1)
						{
							ans[i][j]=0;
							q.add(new pair(i,j));
						}
					}
			}

		while(q.size()!=0)
			{
				pair re = q.remove();
				int fx = re.x;
				int fy = re.y;
				for(int i = 0 ; i<4 ; i++)
					{
						int nx = fx + dx[i]; 
						int ny = fy + dy[i]; 
						if(valid(nx, ny , n , m) && ans[nx][ny]>ans[fx][fy]+1)
						{
							ans[nx][ny] = ans[fx][fy]+1;
							q.add(new pair(nx , ny));
						}
					}
			}
		return ans;
    }

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
            int[][] ans = nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        
    }
}