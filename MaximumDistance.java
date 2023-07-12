import java.util.*;

class Accio
{
    static int MaximumDistance(int N,int[] arr)
	{
		
		HashMap<Integer  , ArrayList<Integer>> map = new HashMap<>();
		for(int i = 0 ; i<N ; i++)
			{
				map.put(arr[i] , new ArrayList<Integer>());
			}
		for(int i = 0 ; i<N ; i++)		
			{
				map.get(arr[i]).add(i);
			}

		int max = 0;
		for(int ele : map.keySet())
			{
				if(map.get(ele).size()>1)
				{
					int l = map.get(ele).get(0);
					int r = map.get(ele).size()-1;
					int diff = map.get(ele).get(r) - l;
					max = Math.max(max , diff);
				}
			}
		return max;
		
    }
}

public class MaximumDistance 
{
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Accio obj = new Accio();
        int ans=obj.MaximumDistance(n,nums);
        System.out.println(ans);
    }
}