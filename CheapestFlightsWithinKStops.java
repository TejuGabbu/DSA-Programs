import java.util.*;
import java.io.*;
class CheapestFlightsWithinKStops
 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int arr[][] = new int[e][3];
        for (int i = 0; i < e; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.findCheapestPrice(n, arr, src, dst, k);
        System.out.println(ans);
        sc.close();
    }
}

class Solution 
{
	static class pair
		{
			int val ;
			int time ;
			int stremain ; 
			
			pair(int val , int time , int stremain)
			{
				this.val = val;
				this.time = time;
				this.stremain = stremain;
			}
		}
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) 
	{
		ArrayList<ArrayList<pair>> graph = new ArrayList<>();
		for(int i = 0 ; i<n ; i++)
			{
				graph.add(new ArrayList<pair>());
			}
		
		for(int ele[] : flights)
			{
				int u = ele[0];
				int v = ele[1];
				int w = ele[2];
				graph.get(u).add(new pair(v,w,0));
			}
		boolean vis[] = new boolean[n];
		PriorityQueue<pair> q = new PriorityQueue<>((a,b)->{
			return a.time - b.time;
		});
		q.add(new pair(src,0,k)); // val , time , stremain
		while(q.size()!=0 && q.peek().stremain>=0)
		{
			pair re = q.remove();
			if(vis[re.val]) continue;
			vis[re.val] = true;
			if(re.val==dst )
			{ 
				return re.time;
			}
			
			if(re.stremain>=0)
			{
			for(pair ele : graph.get(re.val))
				{
					int nbr = ele.val;
					int time = ele.time;
					if(!vis[nbr]) q.add(new pair(nbr , re.time+time , re.stremain-1));
				}
				
			}
		}
		return -1;
		
    }
	
}