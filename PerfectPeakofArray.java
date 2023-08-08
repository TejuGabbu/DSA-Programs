import java.util.*;
import java.lang.*;
import java.io.*;

public class PerfectPeakofArray
 {

  public static int perfectPeak(int[] a) 
	{
	  // write your code here
		HashSet<Integer> set = new HashSet<>();
		Stack<Integer> st = new Stack<>();
		int n = a.length;
		for(int i = 0 ; i<n ; i++)
			{
				set.add(a[i]);
			}
		// System.out.print(set.size());
		if(set.size()<=2) return 0;
		int res[] = new int[n];
		for(int i = n-1 ; i>=0 ; i--)
			{
				if(i==n-1)
				{
					res[i] = -1;
					st.push(i);
					continue;
				}
				if(a[i]>a[st.peek()])
				{
					res[i] = st.peek();
					st.push(i);
				}
				else
				{
					while(st.size()!=0 && a[i]<=a[st.peek()])
						{
							st.pop();
						}
					if(st.size()==0) 
					{
						res[i] = -1;
						st.push(i);
					}
					else
					{
						res[i] = st.peek();
						st.push(i);
					}
				}
			}
		Stack<Integer> s = new Stack<>();
		int res1[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				if(i==0)
				{
					res1[i] = -1;
					s.push(i);
					continue;
				}
				if(a[s.peek()]>a[i])
				{
					res1[i] = s.peek();
					s.push(i);
				}
				else
				{
					while(s.size()!=0 && a[s.peek()]<=a[i])
						{
							s.pop();
						}
					if(s.size()==0)
					{
						res1[i] = -1;
						s.push(i);
					}
					else
					{
						res1[i] = s.peek();
						s.push(i);
					}
				}
			}
		for(int i = 1 ; i<n-1 ; i++)
		{
			if(res[i]==-1 && res1[i]==-1) return 1;
		}		
		return 0;
	}
  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	  int n = sc.nextInt();
  	int[] array = new int[n];
    for(int i=0;i<n;i++)
	    array[i] = sc.nextInt();
		System.out.println(perfectPeak(array));
	}
}