import java.io.*;
import java.lang.*;
import java.util.*;
class Solution
{
    static int findMin(int a[], int low, int high)
    {
        //Write your code here
		if(low==high)
		{
			return a[0];
		}
		int si = 0 ;
		int ei = high;
		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(a[mid-1]>a[mid] && a[mid]<a[mid+1])
				{
					return a[mid];
				}
				else if(si<=a[mid])
				{
					si = mid+1;
				}
				else
				{
					ei = mid-1;
				}
			}
		return -1;
    }
}
class FindMinimuminRotatedSortedArray 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++)
        arr[i] = sc.nextInt();
        System.out.println(Solution.findMin(arr, 0, n - 1));
    }
}