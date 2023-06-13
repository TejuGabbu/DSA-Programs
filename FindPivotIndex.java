import java.util.*;

class Solution {
    public int pivotIndex(int[] nums) 
	{
        //Write code here
		int presum[] = new int[nums.length];
		presum[0] = nums[0];
		for(int i = 1 ; i<nums.length ; i++)
			{
				presum[i] = nums[i] + presum[i-1];
			}
		int left = 0;
		int right = 0;
		int l = nums.length-1;
		for(int i = 0 ; i<nums.length ; i++)
			{
				if(i==0)
				{
					left = 0;
				}
				else
				{
					left = presum[i-1];
				}
				
				right = presum[l] - presum[i];
				if(i==nums.length-1)
				{
					right = 0;
				}
				if(left==right)
				{
					return i;
				}
			}
		return -1;
    }
}

public class FindPivotIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.pivotIndex(arr);
        System.out.println(result);
        sc.close();
    }
}