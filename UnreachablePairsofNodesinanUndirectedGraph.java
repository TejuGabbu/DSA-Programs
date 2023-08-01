import java.util.*;

class UnreachablePairsofNodesinanUndirectedGraph 
{

	public static void main(String[] args)
	{
		int n,k;
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[][] arr = new int [k][2];
        for(int i=0;i<k;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }
		System.out.println(new Solution().countPairs(n,arr));
	}
}

class Solution 
{
    public long countPairs(int n, int[][] edges) 
	{
        //Write code here
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
		long result = 0;
		long size = n;
		boolean vis[] = new boolean[n];
		for(int i = 0 ; i<n ; i++)
			{
				if(!vis[i])	
				{
					vis[i] = true;
					long ct = bfs(graph , vis , i,0);
					 size -= ct;
					result+=size*ct;
				}
			}
		return result;
		
    }
	public static int bfs(ArrayList<ArrayList<Integer>> graph , boolean vis[] , int src , int ct)
	{
		Queue<Integer> qu=new LinkedList<>();
        qu.add(src);
        ct++;
        while(!qu.isEmpty()){
            int curr=qu.poll();
            for(int adjnode:graph.get(curr)){
                if(!vis[adjnode]){
                    qu.add(adjnode);
                    ct++;
                    vis[adjnode]=true;
                }
            }
        }
        return ct;
	}
}