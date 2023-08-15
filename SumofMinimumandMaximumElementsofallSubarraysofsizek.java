import java.util.*;
class Solution{
    public static long sumOfMaxAndMin(int arr[], int n, int k)
    {
        //Write your code here 
		int si = 0;
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->{
			return b - a;
		});
		int ei = 0;
		int sum = 0;
		while(ei<n)
			{
				int val = arr[ei];
				min.add(val);
				max.add(val);
				if(min.size()==k)
				{
					int small = min.peek();
					int large = max.peek();
					sum+= small + large;
					int re = arr[si];
					min.remove(re);
					max.remove(re);
					si++;
				}
				ei++;
			}
		return sum;
		
		
    }
}
public class SumofMinimumandMaximumElementsofallSubarraysofsizek
 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n] ; 
        for(int i = 0 ; i < n ; ++i){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
         System.out.print(Solution.sumOfMaxAndMin(arr, n , k ));
        
    }
}