import java.io.*;
import java.util.*;

class Solution {

    public int[] recentCalls(int[] arr) 
	{
		int n = arr.length;
		int res[] = new int[n];
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 0 ; i<arr.length ; i++)
			{
				q.add(arr[i]);
				if(arr[i]<=3000) 
				{
					res[i] = q.size();
				}
				else
				{
					int val = arr[i] - 3000;
					while(q.size()!=0 && q.peek()<val) q.remove();
						res[i] = q.size();
				}
			}
	
		return res;
    }
}

public class NumberofRecentCalls
 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        int[] ans = Obj.recentCalls(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}