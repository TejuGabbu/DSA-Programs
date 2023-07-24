import java.util.*;

class Solution 
{
    public int UnsortedSubarrayLength(int[] a)
	{
		int n = a.length;
		int temp[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				temp[i] = a[i];
			}
		Arrays.sort(temp);
		int e = 0;
		int s = 0;
		int flag = 0;
		for(int i = 0 ; i<n ; i++)
			{
				if(a[i]!=temp[i])
				{
					s = i;
					flag = 1;
					break;
				}
			}
		for(int i = n-1 ; i>=0 ; i--)
			{
				if(a[i]!=temp[i])
				{
					e = i;
					break;
				}
			}
		if(flag==0)
		{
			return 0;
		}
		return e-s+1;
    }
}

public class ShortestUnsortedContinuousSubarray
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++)
            ar[i] = sc.nextInt();

	    Solution Obj = new Solution();
        System.out.println(Obj.UnsortedSubarrayLength(ar));
    }
}