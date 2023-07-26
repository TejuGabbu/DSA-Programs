import java.math.*;
import java.util.*;
import java.io.*;

class Solution
{
    long minCost(long arr[], int n) 
    {
        //Write your code here
		PriorityQueue<Long> q = new PriorityQueue<>();
		for(int i = 0 ; i<n ; i++)
			{
				q.add(arr[i]);
			}

		long cost = 0;
		while(q.size()>1)
			{
				long f  = q.remove();
				long s = q.remove();
				cost = cost + (f+s);
				q.add(f+s);
			}
		return cost;
    }
}

class MinimumCostofRopes
{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
        
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
			int n = sc.nextInt();
			long arr[] = new long[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextLong();
		    out.println(new Solution().minCost(arr, n));
		out.flush();
	}
}