import java.io.*;
import java.util.*; 

class Main{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for (int i = 0; i < n; ++i){
            array[i] = sc.nextInt();
        }
        Solution ob = new Solution();
        System.out.println(ob.bitonicSequence(n,array));
    } 
} 

class Solution 
{
    static int bitonicSequence(int n, int arr[])
    {
        // code here
		int dp1[] = new int[n];
		dp1[0] = 1;
		for(int i = 1 ; i<n ; i++)
			{
				int bop = 0;
				for(int j = i - 1; j>=0 ; j--)
					{
						if(arr[j]<arr[i])
						{
							bop = Math.max(bop , dp1[j]);
						}
					}
				dp1[i] = bop + 1;
			}

		int dp2[] = new int[n];
		dp2[n-1] = 1;
		for(int i = n-2 ; i>=0 ; i--)
			{
				int bop = 0;
				for(int j = i + 1 ; j<n ; j++ )
					{
						if(arr[j]<arr[i])
						{
							bop = Math.max( bop , dp2[j]);
						}
					}
				dp2[i] = bop + 1;
			}
		int max = 0 ;
		for(int i = 0 ; i<n ; i++)
			{
				int sum = (dp1[i] + dp2[i]) - 1;
				max = Math.max(max , sum);
			}
		return max;
		
    }
} 