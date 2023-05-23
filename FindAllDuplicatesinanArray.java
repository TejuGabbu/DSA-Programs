import java.util.*;

class Solution 
{
    public void allDuplicates(int n, int[] a) 
	{
        // Write Your code here.
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int ele : a)
			{
				map.put(ele , map.getOrDefault(ele,0)+1);
			}
		for(int key : map.keySet())
			{
				if(map.get(key) == 2)
				   {
						System.out.print(key+" ");
				   }
			}
		return;
    }
}

public class FindAllDuplicatesinanArray 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Obj.allDuplicates(n, arr);
        sc.close();
    }
}