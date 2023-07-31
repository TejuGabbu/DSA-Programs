import java.util.*;

class Solution {
    public boolean CanVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) 
	{
        // Write your code here
		int v = rooms.size();
		Queue<Integer> q = new ArrayDeque<>();
		boolean vis[] = new boolean[v];
		q.add(0);
		while(q.size()!=0)
			{
				int re = q.remove();
				if(vis[re]) continue;
				vis[re] = true;
				for(int ele : rooms.get(re))
					{
						if(!vis[ele]) q.add(ele);
					}
			}
		for(int i = 0  ; i<v ; i++)
			{
				if(vis[i]==false) return false;
			}
		return true;
    }
}

public class KeysandRooms 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> r = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j < m; j++) {
                temp.add(sc.nextInt());
            }
            r.add(temp);
        }
	    Solution Obj = new Solution();
        if(Obj.CanVisitAllRooms(r))
            System.out.println("true");
        else
            System.out.println("false");
    }
}