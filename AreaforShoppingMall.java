import java.util.*;

public class AreaforShoppingMall 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        System.out.println(getMaxArea(arr, n));
    }
 // next smaller of left side
	public static int[] findsleft(int a[] , int n)
	{
		int t[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i<a.length ; i++)
			{
				int tej = a[i];
				if(i==0)
				{
					st.push(i);
					t[i] = -1;
				}
				else if(a[st.peek()]<a[i])
				{
					t[i] = st.peek() ; 
					st.push(i);
				}
				else
				{
					while(st.size()!=0 && a[st.peek()]>=a[i])
						{
							st.pop();
						}
					if(st.size()==0)
					{
						t[i] = -1; // 
						st.push(i);
					}
					else
					{
						t[i] = st.peek();
						st.push(i);
					}
				}
			}
		return t;
	}
	
	// next smaller to right side 
	public static int[] findsright(int a[] , int n)
	{
		int tr[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = a.length-1 ; i>=0 ; i--)
			{
				if(i==a.length-1)
				{
					tr[i] = n; // 
					st.push(i);
				}
				else if(a[i]>a[st.peek()])
				{
					tr[i] = st.peek();
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
						tr[i] = n; // 
						st.push(i);
					}
					else
					{
						tr[i] = st.peek();
						st.push(i);
					}
				}
			}
		return tr;
	}
    public static int getMaxArea(int hist[], int n) 
	{
        // your code here
		int left[] = findsleft(hist,n);
		int right[] = findsright(hist,n);
		
		int max = 0;
		for(int i = 0 ; i<n ; i++)
			{
				int height = hist[i];
				int width = right[i] - left[i] - 1;
				int area = (width*height);
				max = Math.max(max,area);
			}
		return max;
    }
}