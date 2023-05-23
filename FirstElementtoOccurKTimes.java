import java.io.*;
import java.util.*;

class Solution {
    public void firstElementToOccurKTimes(int[] a, int n, int k) 
	{
        // Your code here
		HashMap<Integer, Integer> map = new HashMap<>();
		// key is actual number 
		// val is the occurence
		int flag = 0;
		for(int ele : a)
			{
				map.put(ele , map.getOrDefault(ele,0)+1);
				if(map.get(ele)==k)
				{
					flag = 1;
					System.out.print(ele);
					break;
				}
			}
		if(flag==0)
		{
			System.out.print(-1);
		}
		return;
    }
}

public class FirstElementtoOccurKTimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[]nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        Solution Obj = new Solution();
        Obj.firstElementToOccurKTimes(nums,n,k);  
        System.out.println();
    }
}