import java.util.*;
public class NetworkDelayTime 
{
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int v,e;
        v = sc.nextInt();
        e = sc.nextInt();
        //Create adjacency list of edges
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<=v;i++)
            adj.add(new ArrayList<pair>());
        
        for(int i=0;i<e;i++){
            int u,v1,w;
            u = sc.nextInt();
            v1 = sc.nextInt();
            w = sc.nextInt();
			adj.get(u).add(new pair(v1,w));
        }
        Solution obj = new Solution();
        System.out.println(obj.delayTime(v, adj));

    }
}
 class pair
	{
		int val;
		int time;

		pair(int val , int time)
		{
			this.val = val;
			this.time = time;
		}
	}
class Solution
{
    static int delayTime(int V, ArrayList<ArrayList<pair>> graph)
	{
		PriorityQueue<pair> q = new PriorityQueue<>((a,b)->{
			return a.time - b.time;
		});

		q.add(new pair(1,0));
		boolean vis[] = new boolean[V+1];
		int res[] = new int[V+1];
		Arrays.fill(res,Integer.MAX_VALUE);
		while(q.size()!=0)
			{
				pair re = q.remove();
				if(vis[re.val]) continue;
				vis[re.val] = true;
				if(res[re.val]>re.time)
				{
					res[re.val] = re.time;
				}
				for(pair ele : graph.get(re.val))
					{
						int nbr = ele.val;
						int t = ele.time;
						if(!vis[nbr]) q.add(new pair(nbr , re.time+t));
					}
			}
		int max = Integer.MIN_VALUE;
		for(int i = 1 ; i<=V ; i++)
			{
				if(vis[i]==false) return -1;
				max = Math.max(res[i],max);
			}
		return max;
    }
}