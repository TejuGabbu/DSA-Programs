import java.util.*;
import java.lang.*;
import java.io.*;
public class Pgreat
{
    public static void main (String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i = 0 ; i<n ; i++)
			{
				a[i] = sc.nextInt();
			}
		int flag = 0;
		int tejas = 0;
		for(int i = 0 ; i<n ; i++) // 1  ()
			{
				flag = 0;
				if(tejas==0)
				{
					System.out.print("-1 ");
					tejas = 1;
				}
				else
				{
					for(int j = i-1 ; j>=0 ; j--) //0>=0
						{
							if(a[j]>a[i]) //50>1
							{
								System.out.print(a[j]+" ");
								flag = 1;
								break;
							}
							else
							{
								continue;
							}
						}
					if(flag==0)
					{
						System.out.print("-1 ");
					}
				}
					
			}
	}
}