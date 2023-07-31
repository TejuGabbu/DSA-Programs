import java.util.*;

class Solution
{
	public static class pair
		{
			int val ;
			int w ;

			pair(int val , int w)
			{
				this.val = val;
				this.w = w;
			}
		}
    public static ArrayList < Integer > dijkstra(ArrayList < ArrayList < Integer > > edge, int v, int e, int src) 
	{  	
        //Write your code here
		ArrayList<ArrayList<pair>> graph = new ArrayList<>();
		for(int i = 0 ; i<v ; i++)
			{
				graph.add(new ArrayList<pair>());
			}

		for(ArrayList<Integer> ele : edge)
			{
				int u = ele.get(0);
				int v1 = ele.get(1);
				int w = ele.get(2);
				graph.get(u).add(new pair(v1,w));
				graph.get(v1).add(new pair(u,w));
			}
		PriorityQueue<pair> q = new PriorityQueue<>((a,b)->{
			return a.w - b.w;
		});
		q.add(new pair(src,0));
		int res[] = new int[v];
		Arrays.fill(res, Integer.MAX_VALUE);
		boolean vis[] = new boolean[v];
		while(q.size()!=0)
			{
				pair re = q.remove();
				if(vis[re.val]) continue;
				vis[re.val] = true;
				if(res[re.val]>re.w)
				{
					res[re.val] = re.w;
				}

				for(pair ele : graph.get(re.val))
					{
						int nbr = ele.val;
						int wt = ele.w;
						if(!vis[nbr]) q.add(new pair(nbr,re.w+wt));
					}
			}
		ArrayList<Integer> tej = new ArrayList<>();
		for(int i = 0 ; i<v ; i++)
			{
				tej.add(res[i]);
			}
		return tej;
    }
}

class Dijkstra'sshortestpath
{
        public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int v,e;
            v = sc.nextInt();
            e = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i=0;i<e;i++)
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                ArrayList<Integer> node = new ArrayList<>();
                node.add(x);
                node.add(y);
                node.add(w);
                arr.add(node);
            }
            ArrayList<Integer> result = Solution.dijkstra(arr, v, e, 0);
            for(int i=0;i<result.size();i++)
            System.out.print(result.get(i)+" ");
            System.out.println("");
        }
    }
}

