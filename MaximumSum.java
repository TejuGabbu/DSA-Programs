import java.util.*;
import java.lang.*;
import java.io.*;

class MaximumSum 
{
    
    public static int maximumSum(int[] A, int[][] ops) 
	{
		int mod = 1000000007;
	    int presum[] = new int[A.length];
		for(int [] op : ops)
			{
				int l = op[0];
				int r = op[1];

				presum[l]+=1;
				if(r<A.length-1)
				{
					presum[r+1]-=1;
				}
			}

		for(int i = 1 ; i<A.length ; i++)
			{
				presum[i] = (presum[i] + presum[i-1])%mod;
			}

		Arrays.sort(A);
		Arrays.sort(presum);
		int fsum = 0;
		for(int i = 0 ; i<A.length ; i++)
			{
				fsum = (fsum + (A[i]* presum[i])%mod)%mod;
			}
		return fsum%mod;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}



