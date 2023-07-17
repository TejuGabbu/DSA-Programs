
import java.util.*;

public class RemoveDuplicatesfromSortedArray
{
    public static void main(String[] args)
    {
        int n,x;
        Scanner in = new Scanner(System.in);
	    n = in.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
        nums[i]=in.nextInt();
        Solution obj=new Solution();
        obj.solve(nums);

        // for(int i=0;i<k;i++)
        // System.out.print(nums[i]+" ");

        // System.out.println();
    }
    
}

class Solution{
    
    static void solve(int nums[])
    {
        // your code here
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for(int i = 0 ; i<nums.length ; i++)
			{
				set.add(nums[i]);
			}
		for(int ele : set)
			{
				System.out.print(ele+" ");
			}
		
        
    }
}