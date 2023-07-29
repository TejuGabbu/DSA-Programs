//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class MinimumSpanningTree{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public static class pair
		{
			int val;
			int w;

			pair(int val , int w)
			{
				this.val = val;
				this.w = w;
			}
		}
	static int spanningTree(int V, int E, int graph[][]){
	    // Code Here. 
	    PriorityQueue<pair> q = new PriorityQueue<>((a,b)->{
			return a.w - b.w ;
		});

		ArrayList<ArrayList<pair>> g = new ArrayList<>();
		for(int i = 0 ; i<V ; i++)
			{
				g.add(new ArrayList<pair>());
			}

		int n = graph.length;
		
		for(int i = 0 ; i< n; i++)
			{
				int u = graph[i][0];
				int v = graph[i][1];
				int w = graph[i][2];
				g.get(u).add(new pair(v,w));
				g.get(v).add(new pair(u,w));
			}
		
		q.add(new pair(0,0));
		int ct = 0 ;
		boolean vis[] = new boolean[V];
		while(q.size()!=0)
			{
				pair re = q.remove() ;
				if(vis[re.val]==true) continue ;
				vis[re.val]= true ;
				ct+=re.w ;
				
				for(pair ele : g.get(re.val))
					{
						int nbr = ele.val;
						int w = ele.w;
						if(!vis[nbr]) q.add(new pair(nbr ,w));
					}
			}
		return ct;
	}
}