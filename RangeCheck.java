import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] arr, int a, int b) 
	{
        // Write your code here
		HashSet<Integer>st = new HashSet<>();
		int n = arr.length;
		for(int i = 0 ; i<n ; i++)
			{
				int l = arr[i][0];
				int r = arr[i][1];

				for(int j = l ; j<=r; j++)
					{
						st.add(j);
					}
			}
		for(int i = a ; i<=b ; i++)
			{
				if(st.contains(i)==false)
				{
					return false;
				}
			}
		return true;
    }
}

public class RangeCheck 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
	    Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}