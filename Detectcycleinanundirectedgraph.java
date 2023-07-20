import java.io.*;
import java.util.*;

class Solution 
{
	public static boolean check(ArrayList<ArrayList<Integer>> graph , boolean vis[] , int node)
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.add(node);
		while(q.size()!=0)
			{
				int re = q.remove();
				if(vis[re]==true) return true;
				vis[re] = true;
				for(int ele : graph.get(re))
					{
						if(!vis[ele]) q.add(ele);
					}
			}
		return false;
	}
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> graph) 
	{
       // Your code here
		boolean vis[] = new boolean[V];
		for(int i = 0 ; i<V ; i++)
			{
				if(!vis[i])
				{
					if(check(graph , vis , i)) return true;
				}
			}
		return false;
    }
}

public class Detectcycleinanundirectedgraph
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int N, E;
        N = sc.nextInt();
        E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0; i<N; i++) adj.add(i, new ArrayList<Integer>());    
        for(int i =0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean ans = Solution.isCycle(N,adj);
        if(ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
}