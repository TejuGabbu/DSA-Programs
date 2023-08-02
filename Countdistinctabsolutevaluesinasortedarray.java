import java.io.*;
import java.util.*;

class Countdistinctabsolutevaluesinasortedarray
 {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.findDistinctCount(arr));
        sc.close();
    }
}

class Solution 
{
    public int findDistinctCount(int[] nums) 
	{
		HashMap<Integer , Integer> map = new HashMap<>();
		for(int i = 0 ; i<nums.length ; i++)
			{
				if(nums[i]<0)
				{
					nums[i] = -(nums[i]);
				}
				map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
			}
		return map.size();
    }
}