import java.util.*;

class Solution 
{
    public int maxPairs(int[] boys, int[] girls) 
	{
		LinkedHashMap<Integer, Integer> g = new LinkedHashMap<>();
		for(int i = 0 ; i<girls.length ; i++)
			{
				g.put(girls[i] , g.getOrDefault(girls[i] , 0)+1);
			}

		int ct = 0;
		for(int i = 0 ; i<boys.length ; i++)
			{
				int ele = boys[i];
				int val1 = boys[i]+1;
				int val2 = boys[i]-1;
				
				if(g.containsKey(val1))
				{
					ct++;
					g.put(val1 , g.get(val1)-1);
					if(g.get(val1)==0)
					{
						g.remove(val1);
					}
				}
				else if(g.containsKey(val2))
				{
					ct++;
					g.put(val2 , g.get(val2)-1);
					if(g.get(val2)==0)
					{
						g.remove(val2);
					}
				}
				else if(g.containsKey(ele))
				{
					ct++;
					g.put(ele , g.get(ele)-1);
					if(g.get(ele)==0)
					{
						g.remove(ele);
					}
				}
			}
		return ct;
		
    }
}

public class BallroomDance 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int m = sc.nextInt();
        int b[] = new int[m];
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.maxPairs(a, b));
        sc.close();
    }
}