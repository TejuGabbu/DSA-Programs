import java.util.*;

public class CheckwhetheragivengraphisBipartiteornot 
{
	public static class pair
		{
			int number;
			int color;

			pair(int number , int color)
			{
				this.number = number;
				this.color = color;
			}
			
		}
    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) 
	{
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int n = edges.size();
		for(int i = 0 ; i<n ; i++)
			{
				graph.add(new ArrayList<Integer>());
			}

		int m = edges.get(0).size();
		for(int i = 0 ;i<n ; i++)
			{
				for(int j  = 0 ; j<m ; j++)
					{
						if(edges.get(i).get(j)==1)
						{
							graph.get(i).add(j);
							graph.get(j).add(i);
						}
					}
			}

		int vis[] = new int[n];

		Queue<pair> q = new ArrayDeque<>();

		for(int i = 0; i<n ; i++)
			{
				if(vis[i]!=0)
				{
					continue;
				}
				q.add(new pair(i,1));
			
				while(q.size()!=0)
					{
						// we remove it;
						pair re = q.remove();
		
						int anumber = re.number;
						int color = re.color;

						if(vis[anumber]!=0)
						{
							continue;
						}
						vis[anumber] = color;
		
						int oppcolor = (color*(-1));
						for(int val : graph.get(anumber))
							{
								if(vis[val]==0)
								{
									q.add(new pair(val,oppcolor));
								}
								else if(vis[val]==oppcolor)
								{
									continue;
								}
								else if(vis[val]==color)
								{
									return false;
								}
							}
						
					}
			}
		return true;

		
    }

        public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            t--;
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                ArrayList<Integer> row = new ArrayList<>();
                for(int j=0;j<n;j++)
                {
                    row.add(sc.nextInt());
                }
                arr.add(row);
            }
            System.out.println(isGraphBirpatite(arr));
        }
    }
}

