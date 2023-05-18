import java.util.;
import java.io.;

public class FloorinaSortedArray 
{
    public static void main(String args[]) 
	{
        your code here
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int key = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0 ;  in ; i++)
			{
				a[i] = sc.nextInt();
			}
		System.out.print(find(a,key));
    }
	public static int find(int a[] , int key)
	{
		int si = 0;
		int ei = a.length-1;
		while(si=ei)
			{
				int mid = (si+ei)2;
				if(a[mid]==key)
				{
					return mid;
				}
				else if(a[mid]key)
				{
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		if(eisi)
		{
			return ei;
		}
		return -1;
	}
}