import java.io.*;
import java.util.*;
public class SpreadingInfection 
{
   static class Edge 
   {
      int src;
      int nbr;

      Edge(int src, int nbr) 
	   {
	        this.src = src;
	        this.nbr = nbr;
       }
   }

	
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
	  int result = findinfected(graph , src , t,vtces); 
	   System.out.print(result);
   }
	static class pair //  main 
		{
			int val;
			int time;

			pair(int val , int time)
			{
				this.val = val;
				this.time = time;
			}
		}
	public static int findinfected(ArrayList<Edge>[] graph , int src  , int time , int n)
	{
		Queue<pair> q = new ArrayDeque<>();
		q.add(new pair(src , 1));
		boolean vis[] = new boolean[n];
		int ct = 0;
		while(q.size()!=0)
			{
				pair re = q.remove();
				if(vis[re.val]==true) continue;
				vis[re.val] = true;
				if(re.time<=time) 
				{
					ct++;
				}
				else
				{
					return ct;
				}

				for(Edge ele : graph[re.val])
					{
						int nbr = ele.nbr;
						if(!vis[nbr]) q.add(new pair(nbr , re.time+1));
					}
			}
		return ct;
	}

}