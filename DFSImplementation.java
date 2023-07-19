import java.util.*;

class Solution 
{
    public static void DFSTraversal(List<List<Integer>> edges, int n) 
	{
        //Write your code here
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0 ; i<n ; i++)
			{
				graph.add(new ArrayList<Integer>());
			}

		for(List<Integer> ele : edges)
			{
				int u = ele.get(0);
				int v = ele.get(1);

				graph.get(u).add(v);
				graph.get(v).add(u);
			}
		for(int i = 0 ; i<n ; i++)
			{
				Collections.sort(graph.get(i));
			}
		
		boolean vis[] = new boolean[n];
		dfs(graph , vis , 0);
		return;
    }
	public static void dfs(List<List<Integer>> graph , boolean vis[] , int node)
	{
		vis[node] = true;
		System.out.print(node+" ");
		for(int  ele : graph.get(node))
			{
				if(vis[ele]==false)
				{
					dfs(graph , vis , ele);
				}
			}
	}
}

public class DFSImplementation 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        List<List<Integer>> ed = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            List<Integer> l = new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            ed.add(l);
        }

        Solution ob = new Solution();
        ob.DFSTraversal(ed, n);
    }
}