import java.util.*;
public class NumberofValidTriangles 
{
    public static int ValidTriangles(int n,int[] arr)
	{
		Arrays.sort(arr);
		int l = 0;
		int r = 0;
		int ct = 0;
		for(int i = n-1 ; i>=0 ; i--)
			{
				l = 0;
				r = i-1;
				while(l<r)
					{
						if(arr[l]+arr[r]>arr[i])
						{
							ct+=r-l;
							r--;
						}
						else
						{
							l++;
						}
					}
			}
		return ct;
    }
    public static void main(String[] args) throws Throwable 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0;i<n;++i)
		{
            arr[i]=sc.nextInt();
        }
        int ans = ValidTriangles(n,arr);
        System.out.println(ans);
    }
}