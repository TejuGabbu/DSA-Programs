import java.util.*;

class Accio {
    public int longestOnes(int[] arr, int k) 
	{
          //Your code goes here
		int si = 0;
		int ei = 0;
		int max = Integer.MIN_VALUE;
		int noz = 0;
		while(ei<arr.length)
			{
				if(arr[ei]==0) noz++;
				while(noz>k)					
					{
						if(arr[si]==0) noz--;
						si++;
					}
				max = Math.max(max ,ei-si+1);
				ei++;
			}
		return max;
    }
}

public class MaximumOnesAfterModification
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
    	for(int i=0;i<N;i++)
	    A[i] = sc.nextInt();
        int B = sc.nextInt();
        Accio Obj = new Accio();
        System.out.println(Obj.longestOnes(A, B));
    }
}