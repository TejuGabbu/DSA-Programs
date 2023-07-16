import java.io.*;
import java.util.*;
class Solution
{
      public static int numRescueBoats(int[] a, int limit) 
		{
	       Arrays.sort(a);
			// int n = a.length;
			int ct = 0;
			int l = 0;
			int r = a.length-1;
			while(l<=r)
				{
					int sum = a[l] + a[r];
					if(sum<=limit)
					{
						ct++;
						l++;
						r--;
					}
					else if(sum>limit)
					{
						ct++;
						r--;
					}
				}
			return ct;
      }
}
public class BoatstoSavePeople{
	

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
		System.out.println(Solution.numRescueBoats(nums, k));
	}

}
