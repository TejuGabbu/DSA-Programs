import java.util.*;
import java.io.*;

class Solution{
    int minHeight(int[] height, int n,int k)
	{
        // write code here
		int si = 0;
		int ei = 100000;
		int ans = 0;
		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(check(height , mid , k))
				{
					ans = mid;
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		return ans;
    }
	boolean check(int a[] , int mid , int k)
	{
		int wood = 0;
		for(int i = 0 ; i<a.length ; i++)
			{
				if(a[i]>mid)
				{
					wood+=a[i]-mid;
				}
			}
		if(wood>k) return false;
		return true;
	}
}

public class mincuttree {
   public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
       Solution Obj = new Solution();
       int ans = Obj.minHeight(a,n,k);
        System.out.println(ans);
    }
}