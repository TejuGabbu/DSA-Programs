import java.util.*;

class Solution {
    public int findDuplicate(int[] nums) 
	{
        // Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int ele : nums)
			{
				map.put(ele , map.getOrDefault(ele , 0)+1);
			}
		int max = Integer.MIN_VALUE;
		int val = -1;
		for(int ele : map.keySet())
			{
				if(map.get(ele)>max)
				{
					max = map.get(ele);
					val = ele;
				}
			}
		return val;
    }
}

public class FindtheDuplicateNumber
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.findDuplicate(arr));
    }
}