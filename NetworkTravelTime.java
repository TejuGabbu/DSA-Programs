import java.io.*;
import java.util.*;

public class NetworkTravelTime 
{
   public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int n,m,k;
      n=sc.nextInt();
      m=sc.nextInt();
      k=sc.nextInt();
      int[][] a= new int[m][3];
      for(int i=0;i<m;i++){
         int u,v,w;
         u=sc.nextInt();
         v=sc.nextInt();
         w=sc.nextInt();
         a[i][0]=u;
         a[i][1]=v;
         a[i][2]=w;   
      }
      Solution ob = new Solution();
      System.out.println(ob.networkDelayTime(a,n,k));
   }
}
class Solution 
{
	static class pair
	{
		int node;
		int w ;

		pair(int node , int w)
		{
			this.node = node;
			this.w = w;
		}
	}
    public int networkDelayTime(int[][] times, int n, int start) 
	{
		  ArrayList<ArrayList<pair>> graph = new ArrayList<>();
			for(int i = 0 ; i<=n ; i++ )
			{
			    graph.add(new ArrayList<pair>());
			}
		for(int ele[] : times)
			{
				int u = ele[0];
				int v = ele[1];
				int w = ele[2];
			    graph.get(u).add(new pair(v,w));
			}
		int maxwt = bfs(graph ,  start , n);
		return maxwt;
    }
	public static int bfs(ArrayList<ArrayList<pair>> graph  ,int s , int n)
	{
		Queue<pair> q = new ArrayDeque<>();
		int temp[] = new int[n+1];
		Arrays.fill(temp , Integer.MAX_VALUE);
		q.add(new pair(s, 0));
		temp[s] = 0;
		while(q.size()!=0)
			{
				pair curr = q.remove();
				for(pair ele : graph.get(curr.node))
					{
						int val = ele.node;
						int wt = ele.w;
						int arrtime = temp[curr.node] + wt;
						if(temp[val]>arrtime)
						{
							temp[val] = arrtime;
							q.add(new pair(val , curr.w + wt));
						}
					}
			}
		int maxi = 0;
        for (int i = 1; i <= n; i++) {
            if (temp[i] == Integer.MAX_VALUE) 
			{
                return -1;
            }
            maxi = Math.max(maxi, temp[i]);
        }
        return maxi;
	}
	
}