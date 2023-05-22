import java.io.*;
import java.util.*;
import java.util.*;

class Solution
{
	public static boolean check(int a[] , int cows , int max)
	{
		int last = a[0];
		int places = 1;
		for(int i = 1; i<a.length ; i++)
			{
				if(a[i]-last>=max)
				{
					places++;
					last = a[i];
				}
			}
		return places>=cows;
	}
    public static int aggressiveCows(int a[],int cows)
	{ 
	    //Write your code here
		Arrays.sort(a);
		int si = Integer.MAX_VALUE;
			for(int i = 0 ; i<a.length-1 ; i++ )
			{
				int d = a[i+1] - a[i];
				si = Math.min(si,d);
			}
		
		int ei =a[a.length-1] - a[0]; 
		int pans = -1;
		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(check(a,cows,mid)==true)
				{
					pans = mid;
					si = mid+1;
				}
				else
				{
					ei = mid-1;
				}
			}
		return pans;
    }
}

class AggresiveCows 
{
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
        Solution obj=new Solution();
		System.out.println(obj.aggressiveCows(nums,k));
    }
}
