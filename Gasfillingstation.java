import java.util.*;

class Solution 
{
    public int filling(int A[],int B[],int n) 
	{
		int tg = 0;
		int tc = 0;
		for(int i = 0 ; i<n ; i++)
			{
				tg+=A[i];
				tc+=B[i];
			}
		if(tg<tc) return -1;
		int total = 0;
		int sp = -1;
		for(int i = 0 ; i<n ; i++)
			{
				total+=A[i];
				total-=B[i];
				if(total>=0 )
				{
					if(sp==-1)
					{
						sp = i;
					}
				}
				else
				{
					total= 0;
					sp = -1;
				}
			}
		return sp;
    }
}


public class Gasfillingstation 
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
