import java.util.*;
import java.io.*;
 
class Graph 
{
    public int vertices;
    public ArrayList<Integer>[] adjList;
 
    Graph(int v) 
	{
        this.vertices = v+1;
        adjList = new ArrayList[v+1];
        for (int i = 0; i <= v; i++) adjList[i] = new ArrayList<Integer>();
    }
 
    void addEdge(int v, int w) 
	{
        adjList[v].add(w);
    }
 
    void BFS(int x) 
	{
		Queue<Integer> q = new ArrayDeque<>();
		q.add(x);
		boolean vis[] = new boolean[vertices];
		while(q.size()!=0)
			{
				int re = q.remove();
				if(vis[re]==true) continue;
				vis[re]=true;
				System.out.print(re+" ");
				for(int ele : adjList[re])
					{
						if(vis[ele]==false)
						{
							q.add(ele);
						}
					}
			}
		return;
    }
}
 
public class BFSImplementation 
{
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        Graph g = new Graph(110);
        for(int i =0;i<e;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            g.addEdge(x,y);
        }
        g.BFS(0);
    }
}
