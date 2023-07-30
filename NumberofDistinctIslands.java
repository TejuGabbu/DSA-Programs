import java.util.*;

class Solution 
{
  public static int countDistinctIslands(int[][] a) 
	{
		HashSet<ArrayList<String>> set = new HashSet<>();
		int n = a.length;
		int m = a[0].length;
		for(int i = 0 ; i<n ; i++)
			{
				for(int j = 0 ; j<m ; j++)
					{
						if(a[i][j]==1)
						{
							ArrayList<String> psf = new ArrayList<>();
							psf.add("x");
							dfs(a,i,j,n , m , psf);
							set.add(psf);
						}
					}
			}
		return set.size();
	}
	public static void dfs(int a[][] , int row ,int col , int n , int m , ArrayList<String> psf)
	{
		a[row][col] = 0;
		if(row-1>=0 && a[row-1][col]==1)
		{
			psf.add("u");
			dfs(a , row-1 , col , n , m , psf);
		}

		if(col+1 < m && a[row][col+1]==1)
		{
			psf.add("r");
			dfs(a,row,col+1 ,n , m ,  psf);
		}

		if(row+1<n && a[row+1][col]==1)
		{
			psf.add("d");
			dfs(a,row+1,col,n , m , psf);
		}

		if(col-1 >=0 && a[row][col-1]==1)
		{
			psf.add("l");
			dfs(a,row , col-1 , n , m , psf);
		}

		psf.add("z");
		return;
	}
}


public class NumberofDistinctIslands
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution ob = new Solution();
        int ans = ob.countDistinctIslands(grid);
        System.out.println(ans);
    }
}