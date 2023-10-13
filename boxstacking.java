
import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static class Box
		{
			int h;
			int w;
			int l;
			Box(int h , int w , int l)
			{
				this.h = h;
				this.w = w;
				this.l = l;
			}
		}
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        //Write your code here 
		ArrayList<Box> arr = new ArrayList<>();
		for(int i = 0 ; i<n ; i++)
			{
				int h = height[i];
				int w = width[i];
				int l = length[i];

				arr.add(new Box(h , Math.min(w , l) , Math.max(w , l) ));
				arr.add(new Box(l , Math.min(w , h) , Math.max(w , h) ));
				arr.add(new Box(w , Math.min(h , l) , Math.max(h , l) ));
			}

		Collections.sort(arr , (a , b)->{
			return (a.l * a.w) - (b.l * b.w);
		});

		int N = 3 * n;
		int dp[] = new int[N];
		for(int i = 0 ; i<N ; i++)
			{
				int bop = 0;
				int mylen = arr.get(i).l;
				int myWid = arr.get(i).w;
				int myhei = arr.get(i).h;
				for(int j = i-1 ; j>=0 ; j--)
					{
						int prevlen = arr.get(j).l;
						int prevWid = arr.get(j).w;
						if(prevlen < mylen && prevWid < myWid)
						{
							bop = Math.max(bop , dp[j]);
						}
					}
				dp[i] = bop + arr.get(i).h;
			}
		int maxi = 0 ;
		for(int i = 0 ; i<N ; i++)
			{
				maxi = Math.max(maxi ,dp[i]);
			}
		return maxi;
    }
}
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int[] width = new int[n];
        int [] length = new int[n];
        for(int i = 0 ; i < n ; ++i){
            height[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; ++i){
            width[i] = sc.nextInt();
        }
        for(int i = 0 ; i < n ; ++i){
            length[i] = sc.nextInt();
        }
        System.out.print(Solution.maxHeight(height,width,length,n));
	}
}

