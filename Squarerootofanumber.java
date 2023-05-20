import java.util.*;
import java.lang.*;
import java.io.*;

class Squarerootofanumber 
{
    public static int sqrt(int a) 
	{
        // your code here
		if(a==1)
		{
			return 1;
		}
		long si = 1;
		long ei = a-1;

		long pos = 0;
		while(si<=ei)
			{
				long mid = (si+ei)/2;
				if(mid*mid==a)
				{
					return (int)mid;
				}
				else if(((mid+1)*(mid+1)) > a)
				{
					pos = mid;
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		return (int)pos;
    }

  public static void main (String[] args)
	{
    Scanner sc = new Scanner(System.in);
	    
	  int A = sc.nextInt();
	  
    System.out.print(sqrt(A));
		
	}
}