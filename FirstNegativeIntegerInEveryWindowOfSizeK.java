import java.util.*;
class Solution{
    public static int[] printFirstNegativeInteger(int arr[], int n, int k)
    {
		LinkedHashMap<Integer , Integer> map = new LinkedHashMap<>();
		for(int i = 0 ; i<n ; i++)
			{
				if(arr[i]<0)
				{
					map.put(i , arr[i]);
				}
			}

		int si = 0;
		int ei = 0;
		ArrayList<Integer> tej = new ArrayList<>();
		int flag = 0;
		while(ei<n)
			{
				int length = (ei - si)+1;
				flag = 0;
				if(length == k)
				{
					for(int ele : map.keySet())
						{
							if(si<=ele && ele<=ei)
							{
								tej.add(map.get(ele));
								flag = 1;
								break;
							}
						}
					if(flag==0)
					{
						tej.add(0);
					}
					si++;
				}
				ei++;
			}
		int t[] = new int[tej.size()];
		for(int i = 0 ; i<tej.size() ; i++)
			{
				t[i] = tej.get(i);
			}
		return t;
    }
}
public class FirstNegativeIntegerInEveryWindowOfSizeK 
{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n] ; 
        for(int i = 0 ; i < n ; ++i){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int []ans = (Solution.printFirstNegativeInteger(arr, n , k ));
        for(int i = 0 ; i < ans.length ; ++i){
            System.out.print(ans[i] + " ");
        }
    }
}