import java.util.*;

class Solution 
{
    public int longestMountainSubarray(int[] arr) 
	{
		int si = 0;
		int ei = 1;
	   int n = arr.length;
		int iflag = 0;
		int dflag = 0;
		int astart = -1;
		int aend = -1;
		int max = 0;
		int flag = 0;
		while(ei<n)
			{
				if(arr[si]<arr[ei])
				{ //  increase 
					 astart = si;
					while(ei<n && arr[si]<arr[ei])
						{
							si++;
							ei++;
						}
					flag = 1;
				}
				if(flag==1 && ei<n)
				{
					flag = 0;
					while(ei<n && arr[si]>arr[ei])
						{
							si++;
							ei++;
						}
					 aend = si;
					max = Math.max(max , aend - astart +1 );
					si--;
					ei--;
				}
				si++;
				ei++;
			}
		return max;
    }
}

public class LongestMountainSubarray
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int res = Obj.longestMountainSubarray(arr);
        System.out.println(res);
        sc.close();
    }
}