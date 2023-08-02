import java.io.*;
import java.util.*;

class Solution 
{
    public static int[] solve(int[] arr) 
	{
		 Stack<Integer> st = new Stack<>();
		int n = arr.length;
		int res[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				if(i==0) 
				{
					res[i] = -1;
					st.push(i);
					continue;
				}
				if(arr[st.peek()]<arr[i])
				{
					res[i] = i-st.peek();
					st.push(i);
				}
				else 
				{
					while(st.size()!=0 && arr[st.peek()]>=arr[i])
						{
							st.pop();
						}
					if(st.size()==0)
					{
						res[i] = -1;
					}
					else
					{
						res[i] = i-st.peek();;
					}
					st.push(i);
				}
			}
		return res;      
    }
}

public class StudentsPerformanceIII
 {
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