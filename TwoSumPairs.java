import java.util.*;

public class TwoSumPairs 
{

    public static List<List<Integer>> twoSum(int[] arr, int target) 
	{
      // write your code here
		List<List<Integer>> tej = new ArrayList<>();
		int si = 0;
		int n = arr.length;
		int ei = arr.length-1;
		Arrays.sort(arr);
		while(si<ei)
			{
				int sum = arr[si] + arr[ei];
				if(sum==target)
				{
					List<Integer> curr = new ArrayList<>();
					curr.add(arr[si]);
					curr.add(arr[ei]);
					tej.add(curr);
					int prevs = arr[si];
					while(si<n && prevs==arr[si])
						{
							si++;
						}
					
					int preve= arr[ei];
					while(si<ei && preve==arr[ei])
						{
							ei--;
						}
				}
				else if(sum<target)
				{
					int prevs = arr[si];
					while(si<n && prevs==arr[si])
						{
							si++;
						}
				}
				else 
				{
					int preve= arr[ei];
					while(si<ei && preve==arr[ei])
						{
							ei--;
						}
				}
				
			}
		return tej;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int target = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        List<List<Integer>> res = twoSum(arr, target);
        ArrayList<String> finalResult = new ArrayList<>();
        for (List<Integer> list : res) {
            Collections.sort(list);
            String ans = "";
            for (int val : list) {
              ans += val + " ";
            }
            finalResult.add(ans);
        }
        Collections.sort(finalResult);
        for (String str : finalResult) {
            System.out.println(str);
        }
    }
}