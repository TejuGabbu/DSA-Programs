import java.util.*;
import java.lang.*;
import java.io.*;
public class ProductofArrayExceptSelf {
	  public static void main(String[] args) throws Throwable {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();

	        int nums[]=new int[n];
	        for(int i = 0; i < n; i++)
	        {
	            nums[i] = sc.nextInt();
	        }
	        Solution obj = new Solution();
	        long ans[] = obj.ProductOfArrayExceptSelf(n,nums);
	        for(int i=0; i<n ; i++){
	            System.out.print(ans[i] + " ");
	        }
	    }
}
class Solution
{
  public long[] ProductOfArrayExceptSelf(int n, int[] a)
	{
        //write code here
		long all = 1;
		for(int i = 0; i<n ; i++)
			{
				all = all * a[i];
			}
		long tej[] = new long[n];
		for(int i = 0 ; i<n ; i++)
			{
				tej[i] = all/a[i];
			}
		return tej;
	}
}