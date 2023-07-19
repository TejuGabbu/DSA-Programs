import java.util.*;

class Solution 
{
    public static int removeDuplicates(int[] arr) 
	{
		HashMap<Integer , Integer> map = new HashMap<>();
		int n = arr.length;
		for(int i = 0 ; i<n ; i++)
			{
				map.put(arr[i] , map.getOrDefault(arr[i],0)+1);
			}

		int ct = 0;
		for(int ele : map.keySet())
			{
				if(map.get(ele)>2)
				{
					int v = map.get(ele)-2;
					ct = ct + v;
				}
			}
		return n - ct;
    }
}

public class RemoveDuplicatesfromSortedArrayII
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Solution Obj = new Solution();
        System.out.println(Obj.removeDuplicates(arr));
    }
}