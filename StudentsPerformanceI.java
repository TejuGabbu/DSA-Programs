import java.io.*;
import java.util.*;

class Solution 
{
    public static int[] solve(int[] arr) 
	{
		Stack<Integer> st = new Stack<>();
		int n = arr.length-1;
		int tej[] = new int[n+1];
		for(int i = n ; i>=0 ; i--)
			{
				if(i==n) 
				{
					st.push(i); 
					tej[i] = -1;
				}
				if(arr[i]<arr[st.peek()])
				   {
						tej[i] = st.peek() - i;
						st.push(i);
				   }
				else
				{
					while(st.size()!=0 && arr[i]>=arr[st.peek()])
						{
							st.pop();
						}
					if(st.size()==0)
					{
						tej[i] = -1;
					}
					else
					{
						tej[i] = st.peek() - i;
					}
					st.push(i);
				}
			}
		return tej;
    }
}

public class StudentsPerformanceI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int[] result = Obj.solve(arr1);
        for (int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
        System.out.println('\n');
    }
}