import java.io.*;
import java.util.*;

class FindCenterofStarGraph
 
{
    public static void main(String args[]) throws IOException 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) 
		{
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.findCenter(arr,n));
        sc.close();
    }
}

class Solution 
{
    public int findCenter(int[][] edges , int n) 
	{
		HashMap<Integer , Integer> map = new HashMap<>();

		for(int i = 0 ; i<edges.length ; i++)
			{
				int u = edges[i][0];
				int v = edges[i][1];
				map.put(u , map.getOrDefault(u , 0)+1);
				map.put(v , map.getOrDefault(v , 0)+1);
			}
		int max = Integer.MIN_VALUE;
		int tej = 0;
		for(int ele : map.keySet())
			{
				if(map.get(ele)>max)
				{
					max = map.get(ele);
					tej = ele;
				}
			}
		return tej;
    }
}