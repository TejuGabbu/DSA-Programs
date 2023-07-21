import java.util.*;
import java.io.*;

class Node{
    int v, wt;
    Node(int v, int wt){
        this.v = v;
        this.wt = wt;
    }
}
class nodeComparator implements Comparator<Node>{
    public int compare(Node node1, Node node2){
        return node1.wt - node2.wt;
    }
}
class graph{
    ArrayList<ArrayList<Node>> g = new ArrayList<ArrayList<Node>>();
    graph(int n){
        for(int i=0; i<n; i++){
            g.add(new ArrayList<Node>());
        }
    }
    void addNode(int u, int v, int wt){
        g.get(u).add(new Node(v, wt));
    }

    void findPath(int start, int end)
	{
        // Write your code here
		PriorityQueue<Node> q = new PriorityQueue<>((a,b) ->{
			return a.wt - b.wt;
		});
		boolean vis[] = new boolean[g.size()+1];
		q.add(new Node(start , 0));
		while(q.size()!=0)
			{
				Node re = q.remove();
				if(vis[re.v]==true)
					{
						continue;
					}
				vis[re.v] = true;
				if(re.v==end)
				{
					System.out.print(re.wt);
					return;
				}
				for(Node ele : g.get(re.v))
					{
						int nbr = ele.v;
						int wt = ele.wt;
						if(!vis[ele.v])
						{
							q.add(new Node(nbr , re.wt + wt));
						}
					}
			}
		System.out.print("NO");
		return;
    }
}

public class EasyDijkstraProblem
 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        graph g = new graph(n);
        for(int i=0; i < m; i++){
            int u = input.nextInt(), v = input.nextInt();
            int wt = input.nextInt();
            g.addNode(u-1, v-1, wt);
        }
        int start = input.nextInt(), end = input.nextInt();
        g.findPath(start-1, end-1);
    }
}