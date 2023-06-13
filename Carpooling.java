import java.util.*;
import java.lang.*;
import java.io.*;
public class Carpooling 
{
	public static void main(String args[]) 
	{
		 Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] trips = new int[n][3];
		for (int i = 0; i < n; i++)
			{
		        for (int j = 0; j < 3; j++) 
				{
		             trips[i][j] = sc.nextInt();
		        }
		    }
		int k = sc.nextInt();
	    Solution obj= new Solution();
	    System.out.println(obj.carPooling(trips,k));
	 }
}
class Solution
{
    public boolean carPooling(int[][] trips, int capacity) 
	{
		int t[] = new int[1001];
		for(int trip[] : trips)
			{
				int passengers = trip[0];
				int from = trip[1];
				int to = trip[2];
				t[from] +=passengers;
				t[to] -=passengers;
			}

		for(int i = 1 ; i<1001 ; i++)
			{
				t[i] = t[i]+t[i-1];
			}
		for(int i = 0 ; i<t.length ; i++)
			{
				if(t[i]>capacity)
				{
					return false;
				}
			}
		return true;
	}
}