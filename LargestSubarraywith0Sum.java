import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution 
{
   public int maxLen(int a[])
	{
		int n = a.length;
		HashMap<Integer,Integer> map = new HashMap<>();
		
		map.put(0,-1);
		int presum = 0;
		int max = 0;
		for(int i = 0 ; i<n ; i++)
			{
				presum = presum + a[i];
				if(map.containsKey(presum)==false)
				{
					map.put(presum,i);
				}
				else
				{
					int length = i - map.get(presum);
					if(length>=max)
					{
						max = length;
					}
				}
			}
		return max;
	}
}

class LargestSubarraywith0Sum
{
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
		{
			nums[i] = sc.nextInt();
		}
        Solution Obj = new Solution();
		System.out.println(Obj.maxLen(nums));
	}
}
