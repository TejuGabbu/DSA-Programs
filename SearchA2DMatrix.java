import java.util.*;

public class SearchA2DMatrix 
{
	
    public static boolean Search(int[][] a, int x) 
	{
        //Write your code here
            // Return true or false
		int n = a.length;
		int m = a[0].length-1;
		int si = 0;
		int ei = n-1;
		int pos = -1;
		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(a[mid][m]==x)
				{
					return true;
				}
				else if(a[mid][m]>x)
				{
					pos = mid;
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		if(pos==-1)
		{
			return false;
		}
		 // we obtain the row'th index;
		si = 0;
		ei = m-1;

		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(a[pos][mid]==x)
				{
					return true;
				}
				else if(a[pos][mid]>x)
				{
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		return false;
		
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++)
                mat[i][j] = sc.nextInt();
        }
        int x = sc.nextInt();
        if(Search(mat, x))
            System.out.println("true");
        else
            System.out.println("false");
    }
}