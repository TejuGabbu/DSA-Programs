import java.util.*;

class MaximumContiguousSubarraySum {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution
{
    public long maxSubarraySum(int a[],int n)
	{
		int train = 0;
		long maxi = Long.MIN_VALUE;
		for(int i = 0 ; i<n ; i++)
			{
				int newtrain = a[i];
				int prevtrain = train + a[i];
				train = Math.max(newtrain , prevtrain);
				maxi = Math.max(train , maxi);
			}
		return maxi;
    }
}