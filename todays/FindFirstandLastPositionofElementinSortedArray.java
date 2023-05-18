import java.util.*;

public class FindFirstandLastPositionofElementinSortedArray
{
	public static int firstindex(int a[], int k)
	{ 
		//  function for finding  first index
		int si = 0;
		int ei = a.length-1;

		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(a[mid]==k)
				{
					ei = mid-1;
				}
				else if(a[mid]>k)
				{
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		if(ei<si && a[si]==k)
		{
			return si;
		}
		return -1;
		
	}
	public static int lastindex(int a[], int k)
	{ 
		//  function for finding  last index
		int si = 0;
		int ei = a.length-1;
		while(si<=ei)
			{
				int mid = (si+ei)/2;
				if(a[mid]==k)
				{
					si = mid+1;
				}
				else if(a[mid]>k)
				{
					ei = mid-1;
				}
				else
				{
					si = mid+1;
				}
			}
		if(ei<si && a[ei]==k)
		{
			return ei;
		}
		return -1;
		
	}
	
    public static void findPosition(int a[],int k)
    {
        // Write code here
		if(a.length==0)
		{
			System.out.print(-1+" "+-1);
			return;
		}
		int f = firstindex(a,k);
		int l = lastindex(a,k);
		System.out.print(f+" "+l);
		
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,k);
    }
}