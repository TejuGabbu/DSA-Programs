import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long  a[] , int n)
    { 
		Stack<Long> st = new Stack<Long>();
		long f[] = new long[n];
		for(int i = n-1 ; i>=0 ; i--)
			{
				if(i==n-1)
				{
					long p = a[i];
					f[i] = -1;
					st.push(p); // 4
				}
				else
				{
					long t = a[i];
					if(st.peek()>a[i])
					{
						f[i] = st.peek();
						st.push(t);
					}
					else
					{
						while(st.size()>0 && st.peek()<=a[i])
							{
								st.pop();
							}
						if(st.size()==0)
						{
							f[i] = -1;
						}
						else
						{
							f[i] = st.peek();
						}
						st.push(t);
					}
				}
			}
		return f;
    } 
}
class NextGreat {
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
	}
}