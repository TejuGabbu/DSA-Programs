import java.io.*;
import java.util.*;
public class PeakIndexinaMountainArray
{
    public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				a[i] = sc.nextInt();
			}
		int count = 0;
		for(int i = 0 ; i<n ; i++) // 1
			{
				count = 0;
				for(int j = 0 ; j<i ; j++)
					{
						if(a[j]<a[i])
						{
							count++;
						}
					}
				for(int k = i+1 ; k<n; k++)
					{
						if(a[i]>a[k])
						{
							count++;
						}
					}
				if(count==n-1)
				{
					System.out.print(i);
					break;
				}
			}
    }
}