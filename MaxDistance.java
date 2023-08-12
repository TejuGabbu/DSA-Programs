import java.io.*;
import java.util.*;

class MaxDistance
 {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		
	}
}


class Solution{
    
    static class pair
		{
			int val ;
			int ind;
			pair(int val  , int ind)
			{
				this.val = val;
				this.ind = ind;
			}
		}
    static int maxIndexDiff(int a[], int N) 
	{ 
		ArrayList<pair> tej = new ArrayList<>();		
        for(int i =0 ; i<N ; i++)
			{
				tej.add(new pair(a[i],i));
			}

		Collections.sort(tej , (c,b)->{
			return c.val - b.val;
		});

		int bigindex[] = new int[N];
		Stack<Integer> st = new Stack<>();
		for(int i = N-1 ; i>=0 ; i--)
			{
				int val = tej.get(i).ind;
				if(i==N-1)
				{
					bigindex[i]=val;
					st.push(val);
					continue;
				}
				if(val>st.peek())
				{
					while(st.size()!=0)
						{
							st.pop();
						}
					if(st.size()==0)
					{
						bigindex[i] = val;
						st.push(val);
					}
				}
				else
				{
					bigindex[i] = st.peek();
				}
			}
		// main here
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i<N ; i++)
			{
				int val = tej.get(i).val;
				int actualindx = tej.get(i).ind;
				int nexindx = bigindex[i];
				max = Math.max(max , nexindx - actualindx);
			}
		return max;
    }
}


