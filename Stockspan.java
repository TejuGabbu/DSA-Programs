import java.io.*;
import java.util.*;

class Pair
{
    int val;
    int idx;
    Pair(int val, int idx)
	{
        this.val = val;
        this.idx = idx;
    }
}

public class Stockspan
{
    public static void main(String args[]) 
	{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
		{
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++)
		{
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution 
{
	static int[] greaterindex(int a[])
	{
		Stack<Integer> st = new Stack<>();
		int f[] = new int[a.length];
		for(int i = 0 ; i<a.length ; i++)
			{
				int t = a[i];
				if(i==0)
				{
					st.push(i);
					f[i] = -1;
					continue;
				}
				else
				{
					if(a[st.peek()]>a[i])
					{
						f[i] = st.peek();
						st.push(i);
					}
					else
					{
						while(st.size()>0 && a[st.peek()]<=a[i])
							{
								st.pop();
							}
						if(st.size()==0)
						{
							f[i] = -1;
							st.push(i);
						}
						else
						{
							f[i] = st.peek();
							st.push(i);
						}
					}
				}
			}
		return f;
	
	}
    static int[] stockSpan(int [] a) 
	{
        int tej[] = greaterindex(a); // index of greater elements
		int shr[] = new int[a.length];
		for(int i = 0 ; i<a.length ; i++)
			{
				shr[i] = i - tej[i];
			}
		return shr;
		
    }
}