import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
	public static int diffPossible(int[] a, int k) 
	{
        //Write your code here        
		int si = 0 ;
		int ei = 0;
		while(ei<a.length)
			{
				int diff = a[ei]-a[si];
				if(diff==k)
				{
					return 1;
				}
				else if(diff<k)
				{
					ei++;
				}
				else
				{
					si++;
				}
			}
		return 0;
		
    }
}
public class DiffK
 {
	 public static void main (String[] args)
		{
			Scanner sc = new Scanner(System.in);		    
		    	int n = sc.nextInt();
				int[] A = new int[n];
				for(int i=0;i<n;i++)
				A[i] = sc.nextInt();
				int k= sc.nextInt();           
	    	Solution Obj= new Solution();	    	
            System.out.println(Obj.diffPossible(A, k));
	}
}