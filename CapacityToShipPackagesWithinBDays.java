import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static boolean check(int a[] , int days , long max)
	{
		int s = 1;
		long d = 0;
		for(int i = 0 ; i<a.length ; i++)
			{
				if(d+a[i]<=max)
				{
					d = d+a[i];
				}
				else
				{
					s++;
					d = a[i];
				}
			}
		return s<=days;
	}
    public static long solve(int[] a, int days) 
	{
        //Write your code here 
		long si = 0;
		long ei = 0;
		for(int i : a)
			{
				si = Math.max(i,si);
				ei = ei + i;
			}
		long ptans = -1;
		while(si<=ei)
			{
				long mid = (si+ei)/2;
				if(check(a,days,mid)==true)
				{
					ptans = mid;
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		return ptans;
    }
}

class CapacityToShipPackagesWithinBDays {
        public static void main (String[] args){
                Scanner sc = new Scanner(System.in);
        	int n = sc.nextInt();
        	int[] A = new int[n];
        	for(int i=0;i<n;i++){
                        A[i] = sc.nextInt();
		}
                int B = sc.nextInt();
                System.out.println(Solution.solve(A,B));
	}
}