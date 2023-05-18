import java.util.*;

class Solution
{
	static int[] nextGreaterElementOnRightIndexwise(int[] a, int n) {
		// Stack: people looking for nger
		Stack<Integer> st = new Stack<>();

		int[] ngeri = new int[n];

		// left to right
		for (int i = 0; i < n; i++) {
			long ele = a[i];

			while (st.size() > 0 && ele > a[st.peek()]) {
				int idx = st.pop();
				ngeri[idx] = i;
			}

			st.push(i);
		}

		while (st.size() > 0) {
			int idx = st.pop();
			ngeri[idx] = n;
		}

		return ngeri;
	}
	
    static int[] SlidingWindowMaximum(int N, int K, int[] arr){
        // write code here
		int[] ngeri = nextGreaterElementOnRightIndexwise(arr, N);

		int[] ans = new int[N - K + 1];
		
		int j = 0;
		for (int i = 0; i <= N - K; i++) {
			if (j < i) {
				j = i;
			}

			while (ngeri[j] < i + K) {
				j = ngeri[j];
			}

			ans[i] = arr[j];
		}

		return ans;
    }
}

public class SlidingwindowMaximum{
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int nums[]=new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj = new Solution();
        int[] ans=obj.SlidingWindowMaximum(n,k,nums);
        for(int i=0;i<ans.length;++i){
            System.out.print(ans[i] + " ");
        }
    }
}
