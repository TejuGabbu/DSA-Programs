import java.util.*;
class Solution 
{
    public int findElement(int[] a, int n) 
	{
        // Write your code here
		if(a.length==1)
		{
			return 0;
		}
		Stack<Integer> st = new Stack<>();
		int left[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				if(i==0)
				{
					st.push(i);
					left[i] = -1;
					continue;
				}

				
				if(a[st.peek()]>a[i])
				{
					left[i] = st.peek();
					st.push(i);
				}
				else
				{
					while(st.size()!= 0 && a[st.peek()]<=a[i])
						{
							st.pop();
						}
					if(st.size()==0)
					{
						left[i] = -1;
						st.push(i);
					}
					else
					{
						left[i] = st.peek();
						st.push(i);
					}
				}
			}

		Stack<Integer> st1 = new Stack<>();
		int right[] = new int[n];
		for(int i = n-1 ; i>=0 ; i--)
			{
				if(i==n-1)
				{
					st1.push(i);
					right[i] = -1;
					continue;
				}
				
				if(a[i]>a[st1.peek()])
				{
					right[i] = st1.peek();
					st1.push(i);
				}
				else
				{
					while(st1.size()!=0 && a[i]<=a[st1.peek()])
					{
						st1.pop();
					}
					if(st1.size()==0)
					{
						right[i] = -1;
						st1.push(i);
					}
					else
					{
						right[i] = st.peek();
						st1.push(i);
					}
				}
			}
			for(int i = n-1 ; i>=0 ; i--)
			{
				if(i!= 0 && left[i] == -1 && right[i] == -1 && a[i]!=a[i-1] )
				{
					return i;
				}
			}
		return -1;
    }
}

public class FindHingedElement 
{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}

        Solution Obj = new Solution(); 
		System.out.println(Obj.findElement(nums, n));
	}
}