import java.util.*;

public class SmallerThanTripletSum 
{
    public static void main(String[] args) throws Throwable 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++) 
		{
            A[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int ans = Solution.threeSumSmaller(n,A,target);
        System.out.println(ans);
    }
}

class Solution 
{
    static int threeSumSmaller(int n, int[] arr, int target) 
	{
		Arrays.sort(arr);
		int i = 0;
		int ct = 0;
		while(i<n)
			{
				int j = i+1;
				int k = n-1;
				while(j<k)
					{
						int sum = arr[i] + arr[j] + arr[k]; 
						if(sum<target)
						{
							ct = ct + (k-j);	
							j++;
							// break;
						}
						else
						{
							k--;
						}
					}
				i++;
			}
		return ct;
    }
}