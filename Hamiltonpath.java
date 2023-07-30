import java.io.*;
import java.util.*;

class Hamiltonpath
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
        Solution ob = new Solution();
        if (ob.check(N, M, Edges)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        sc.close();
    }

}

class Solution {
    
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
	{
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

		boolean pvis[] = new boolean[N+1];
		for(int i = 1 ; i<=N ; i++)
			{
				ArrayList<Integer> path = new ArrayList<>();
				boolean f = dfs(graph , pvis , path ,i,N);
				if(f) return true;
			}
		return false;
    
    }
	public static boolean dfs(ArrayList<ArrayList<Integer>> graph , boolean pvis[] , ArrayList<Integer> path , int curr, int N)
	{
		path.add(curr);
		if(path.size()==N)
		{
			path.remove(path.size()-1);
			pvis[curr] = false;
			return true;
		}
		pvis[curr] = true;
		for(int nbr : graph.get(curr))
			{
				if(!pvis[nbr]) 
				{
					boolean t = dfs(graph , pvis, path , nbr , N);
					if(t) return true;
				}
			}
		pvis[curr] = false;
		path.remove(path.size()-1);
		return false;
	}
}