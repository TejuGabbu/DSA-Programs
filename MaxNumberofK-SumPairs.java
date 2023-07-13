import java.util.*;
class Solution 
{
    public int maxOperations(int[] nums, int k) 
	{
		HashMap<Integer , Integer> map = new HashMap<>();
		int n = nums.length;
		ArrayList<Integer> tej = new ArrayList<>();
		for(int i = 0 ; i<n ; i++)
			{
				map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
				tej.add(nums[i]);
			}

		// n = tej.size();
		int ct = 0;
		for(int i = 0 ; i<n ; i++)
			{
				int diff = k - nums[i];
				if(map.containsKey(diff)==true)
				{
					if(nums[i]==diff)
					{
						if(map.get(diff)>=2)
						{
							map.put(diff,map.get(diff)-2);
							ct++;
						}
						
						if(map.get(diff)==0)
						{
							map.remove(diff);
						}

					}
					else
					{
						 if(map.containsKey(nums[i]) && map.containsKey(diff) && map.get(nums[i]) > 0 && map.get(diff) > 0)
						    {
						        ct++;
						        map.put(nums[i] , map.get(nums[i])-1);
						        map.put(diff , map.get(diff)-1);
						        if(map.get(nums[i])==0)
							    {
							        map.remove(nums[i]);
							    }
						        if(map.get(diff)==0)
						        {
						            map.remove(diff);
						        }
								
							}
					}
				}
		    }
		return ct;
}
}

public class MaxNumberofK-SumPairs 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.maxOperations(arr, k);
        System.out.println(result);
        sc.close();
    }
}