import java.util.*;
class Node
	{
		int val;
		Node left;
		Node right;

		Node(int val)
		{
			this.val = val;
		}
	}
class Solution 
{
    public boolean OneChild(int[] arr, int n) 
	{
        // Write your code here
		for(int i = 0 ; i<n-2 ; i++)
			{
				int j = i+1;
				int k = j +1;
				if(arr[i]>arr[j] && arr[i]<arr[k])
				{
					return false;
				}
				else if(arr[i]<arr[j] && arr[i]>arr[k])
				{
					return false;
				}
			}
		return true;
    }
}

public class ExactlyOneChild {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i = 0; i < n; ++i)
            p[i] = (sc.nextInt());
        Solution Obj = new Solution();
        if(Obj.OneChild(p, n))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
