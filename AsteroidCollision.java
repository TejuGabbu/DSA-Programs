import java.util.*;

class Solution 
{
    public int[] asteroidCollision(int[] a) 
	{
        //Write code here
		Stack<Integer> st = new Stack<>();
		int n = a.length;
		for(int i = 0 ; i<n ; i++)
			{
				int ele = a[i];
				if(i==0)
				{
					st.push(ele);
				}
				else if(st.peek()>=0 && ele>=0)
				{
					st.push(ele);
				}
				else if(st.peek()<0 && ele<0)
				{
					st.push(ele);
				}
				else if(st.peek()<0 && ele>=0)
				{
					st.push(ele);
				}
				else
				{
					int tej = ele;
					ele = ele * (-1);
					while(st.size()!=0 && st.peek()>=0)
						{
							if(st.peek()==ele)
							{
								break;
							}
							else if(st.peek()>ele)
							{
								break;
							}
							else
							{
								st.pop();
							}
						}
					if(st.size()!=0 && st.peek()==ele)
					{
						st.pop();
						continue;
					}
					if(st.size()!=0 && st.peek()>ele)
					{
						continue;
					}
					st.push(tej);
				}
				
			}
		int t[] = new int[n];
		int k = 0;
		while(st.size()!=0)
			{
				t[k] = st.pop();
				k++;
			}
		int m[] = new int[k];
		int p = 0;
		for(int i = k-1 ; i>= 0 ; i--)
			{
				m[p] = t[i];
				p++;
			}
		return m;
    }
}

public class AsteroidCollision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.asteroidCollision(arr);
        for (int i = 0; i < result.length; ++i)
            System.out.print(result[i] + " ");
        System.out.println();
        sc.close();
    }
}