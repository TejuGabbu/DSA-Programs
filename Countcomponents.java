import java.io.*;
import java.util.*;
class Countcomponents 
{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            String S[] = read.readLine().split(" ");
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=0; j<N; j++)
                temp.add(Integer.parseInt(S[j]));
            adj.add(temp);
        }

        Solution ob = new Solution();
        System.out.println(ob.components(adj,N));
    }
}

class Solution 
{
    int components(ArrayList<ArrayList<Integer>> adj, int N) 
	{
		ArrayList<ArrayList<Integer>> tej = new ArrayList<>();
		for(int i = 0 ; i<adj.size() ; i++)
			{
				tej.add(new ArrayList<Integer>());
			}
		for(int i = 0 ; i<adj.size() ; i++)
			{
				for(int j = 0 ; j<adj.get(i).size() ; j++)				
					{
						if(adj.get(i).get(j)==1 && i!=j)
						{
							tej.get(i).add(j);
							tej.get(j).add(i);
						}
					}
			}
		int v = tej.size();
		boolean vis[] = new boolean[v];
		int ct = 0;
		for(int i = 0 ; i<v ; i++)
			{
				ArrayList<Integer> temp = new ArrayList<>();
				if(!vis[i])
				{
					dfs(tej,vis , i, temp);
					ct++;	
				}
			}
		return ct;
    }
	public static void dfs(ArrayList<ArrayList<Integer>> tej , boolean vis[] , int src , ArrayList<Integer> temp )
	{
		vis[src] = true;
		temp.add(src);
		for(int ele : tej.get(src))
			{
				if(!vis[ele])
				{
					dfs(tej, vis , ele , temp);
				}
			}
		return;
	}
}