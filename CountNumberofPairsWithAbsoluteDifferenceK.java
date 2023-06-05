import java.io.*;
import java.util.*;

class Solution 
{
    public long pairDifference(int a[], int n, int k) 
	{
       // write code here
		HashMap<Integer , Integer> map = new HashMap<>();
		int diff1 = 0;
		int diff2 = 0;
		for(int i = 0 ; i<a.length ; i++)
			{
				diff1 = 0;
				diff2 = 0;
				if(map.containsKey(a[i]-k)==true)
				{
					diff1 = a[i]-k;
				}
				
				if(map.containsKey(a[i]+k)==true)
				{
					diff2 = a[i]+k;
				}
				
				if(map.containsKey(diff1)==true)
				{
					map.put(diff1,map.getOrDefault(diff1,0)+1);
					if(map.containsKey(a[i])==false)
					{
						map.put(a[i],0);
					}
				}
				
				if(map.containsKey(diff2)==true)
				{
					map.put(diff2,map.getOrDefault(diff2,0)+1);
					if(map.containsKey(a[i])==false)
					{
						map.put(a[i],0);
					}
				}
				
				if(map.containsKey(diff1)==false && map.containsKey(diff2)==false) 
				{
					map.put(a[i],0);
				}
			}
		long ct = 0;
		for(int ele : map.keySet())
			{
				if(map.get(ele)>=1)
				{
					ct++;
				}
			}
		return ct;
    }
}

public class CountNumberofPairsWithAbsoluteDifferenceK 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.pairDifference(mat,n,k));
        System.out.println('\n');
    }
}
