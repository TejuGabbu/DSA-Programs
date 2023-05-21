import java.util.*;
import java.lang.*;
import java.io.*;
class Solution 
{
	public boolean check(int a[] , int s , long maxpages)
	{
		int stu = 1;
		int pages = 0;

		for(int i : a)
			{
				if(pages+i<=maxpages)
				{
					pages = pages+i;
				}
				else
				{
					stu++;
					pages = i;
				}
			}
		return stu<=s;
	}
    public long MinimumPages(int[] a, int s) 
	{
        //Write your code here
		if(a.length<s)
		{
			return -1;
		}
		long si = 0;
		long ei = 0;

		for(int i : a)
			{
				si = Math.max(si,i);
				ei +=i;
			}
		long pos = -1;
		while(si<=ei)
			{
				long mid = (si+ei)/2;
				if(check(a,s,mid)==true)
				{
					pos = mid;
					ei = mid-1;
				}
				else 
				{
					si = mid+1;
				}
			}
		return pos;
		
    }
}

class AllocateMinimumNumberOfPages 
{
    public static void main (String[] args) 
	{
        Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution(); 
        System.out.println(Obj.MinimumPages(A,B));
	}
}