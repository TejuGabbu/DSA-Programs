import java.io.*;
import java.util.*;

class Solution 
{
	public static int solve(int[] arr, int k) 
	{
		int l = 0;
		int r = 0;
		int n = arr.length;
		int sum = 0;
		int ct = 0;
		
		while(r<n)
			{
				sum = sum + arr[r];
				while(sum>=k)
					{
						sum = sum - arr[l];
						l++;
					}
				ct = ct + ((r-l)+1);
				r++;
			}
		return ct;
	}
}

public class CountingSubarrays
{
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
	    
    	int n = sc.nextInt();
    	int[] A = new int[n];
    	for(int i=0;i<n;i++)
        A[i] = sc.nextInt();
        int B = sc.nextInt();
        Solution Obj= new Solution();
        System.out.println(Obj.solve(A, B));
	
    }
}