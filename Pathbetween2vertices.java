import java.io.*;
import java.util.*;

class Pathbetween2vertices 
{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < M; i++) {
            ArrayList<Integer> e = new ArrayList<Integer>();
            e.add(sc.nextInt());
            e.add(sc.nextInt());
            Edges.add(e);
        }
        int U=sc.nextInt();
        int V=sc.nextInt();
        Solution ob = new Solution();
        if (ob.check(N, M, Edges,U,V)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution 
{
public boolean ch(ArrayList<ArrayList<Integer>> graph , boolean vis[] , int u , int v)    
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.add(u);
		while(q.size()!=0)
			{
				int re = q.remove();
				if(re==v) return true;
				if(vis[re]==true) continue;
				vis[re] = true;

				for(int ele : graph.get(re))
					{
						if(!vis[ele]) q.add(ele);
					}
			}
		return false;
	}
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) 
	{
        // your code here
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0 ; i<=N ; i++)
			{
				graph.add(new ArrayList<Integer>());
			}
		
		for(ArrayList<Integer> ele : Edges)
			{
				int u = ele.get(0);
				int v = ele.get(1);
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
		boolean vis[]  = new boolean[N+1];
		return ch(graph , vis , U , V);
		
    }
}