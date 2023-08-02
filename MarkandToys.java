import java.util.*;
public class MarkandToys 
{
    public static void main(String[] args) throws Throwable 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long mo = sc.nextLong();
	    long a[]  = new long[n];
        for(int i=0;i<n;++i)
		{
            a[i] = sc.nextLong();
        }
        Arrays.sort(a); //
		long sum = 0;
		long count = 0l;
		for(int i = 0 ; i<n ; i++)
			{
				sum =  sum + a[i];
				if(sum<=mo)
				{
					count++;
				}
				if(sum>mo)
				{
					break;
				}
			}
		System.out.print(count);
    }
}