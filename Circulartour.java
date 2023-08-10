import java.util.*;
class Circulartour
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int p[] = new int[n];
			int d[] = new int[n];
			for(int i = 0 ; i<n; i++)
				{
					p[i] = sc.nextInt();
				}
			for(int i = 0 ; i<n; i++)
				{
					d[i] = sc.nextInt();
				}
		Solution ob = new Solution();
		System.out.print(ob.tour(p,d));
	}
}
class Solution
{
	int tour(int p[], int d[])
	{
		int n = p.length;
		int pe = 0;
		int dis = 0;
		for(int i = 0 ; i<n ; i++)
			{
				pe+=p[i];
				dis+=d[i];
			}
		if(pe<dis) return -1;
		int gas = 0;
		int start = -1;
		for(int i = 0 ; i<n ; i++)
			{
				gas+=p[i];
				gas-=d[i];
				if(gas<0)
				{
					gas = 0;
					start = -1;
				}
				else
				{
					if(start==-1) start = i;
				}
				
			}
		return start;
	}
}