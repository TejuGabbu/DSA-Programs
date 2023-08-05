import java.util.*;

public class IsGraphTree
 {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
        for(int i=0;i<m;i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<2;j++) {
                arr.add(sc.nextInt());
            }
            edgeList.add(arr);
        }
        boolean ans = Solution.isGraphTree(n, edgeList);
        if(ans) {
            System.out.print("1\n");
        }
        else {
            System.out.print("0\n");
        }
    }
}
class Solution 
{
    static boolean isGraphTree(int n, ArrayList<ArrayList<Integer>> edgeList) 
    {
       ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0 ; i<n ; i++)
			{
				graph.add(new ArrayList<Integer>());
			}
		
		for(ArrayList<Integer> ele : edgeList)
			{
				int u = ele.get(0);
				int v = ele.get(1);
				graph.get(u).add(v);
				graph.get(v).add(u);
			}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		boolean vis[] = new boolean[n];
		while(q.size()!=0)
			{
				int re = q.remove();
				if(vis[re]) return false;
				vis[re] =  true;
				for(int ele : graph.get(re))
					{
						if(!vis[ele]) q.add(ele);
					}
			}
		return true;
    }
}