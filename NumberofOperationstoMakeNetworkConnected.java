import java.util.*;
class Solution{
    
    
    public static int makeConnected(int n , int[][] edges)
	{
        //write your code here
        
		int m = edges.length;
		if(m<n-1) return -1;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i = 0 ; i<n ; i++)
			{
				graph.add(new ArrayList<Integer>());
			}

		for(int ele[] : edges)
			{
				int u = ele[0];
				int v = ele[1];
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
		
		boolean vis[] = new boolean[n];
		int ct = 0;
		for(int i = 0 ; i<n ; i++)
			{
				if(!vis[i])
				{
					dfs(graph , vis , i);
					ct++;
				}
			}
		return ct - 1;
    }
	public static void dfs(ArrayList<ArrayList<Integer>> graph , boolean vis[] , int src)
	{
		if(src>=vis.length || vis[src]==true) return ;
		vis[src] = true;
		for(int ele : graph.get(src))
			{
				dfs(graph , vis , ele);
			}
		return;
		
	}
}
public class NumberofOperationstoMakeNetworkConnected
 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][2] ; 
        for(int i = 0 ; i < m ; ++i){
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        System.out.print(Solution.makeConnected(n,edges));
    }
}