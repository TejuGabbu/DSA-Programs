import java.util.*;

class Solution {
    static void printMax(int arr[], int N, int K)
    {
        // Your code here
		PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->{
			return b - a;
		});
		int si = 0;
		int ei = 0;
		while(ei<N)
			{
				int val = arr[ei];
				max.add(val);
				int len = ei - si + 1;
				if(len==K)
				{
					System.out.print(max.peek()+" ");
					int re = arr[si];
					max.remove(re);
					si++;
				}
				ei++;
			}
		return;
    }
}

public class MaximumExamScores
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        Obj.printMax(arr1, n ,k);
        System.out.println('\n');
    }
}