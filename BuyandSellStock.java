import java.util.*;
import java.io.*;
 
public class BuyandSellStock 
{
    public static void main(String args[]) 
	{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
		{
            a[i] = input.nextInt();
        }
        int ans = Solution.bestTimeToBuyAndSell(n,a);
        System.out.println(ans);
    }
    
}
 
 
class Solution 
{
   static int bestTimeToBuyAndSell(int n, int[] a) 
	{
		int tej[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = n-1 ; i>=0 ; i--)
			{
				if(i==n-1)			
				{
					tej[i] = -1;
					st.push(a[i]);
				}
				else if(a[i]<st.peek())
				{
					tej[i] = st.peek();
				}
				else
				{
					tej[i] = -1;
					st.push(a[i]);
				}
			}
		int max = 0;
		for(int i= 0 ; i<n ; i++)
			{
				int diff = tej[i] - a[i];
				max = Math.max(diff , max);
			}
		return max;
    }
}