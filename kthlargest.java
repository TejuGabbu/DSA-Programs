import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
    int k = sc.nextInt();
    sc.close();
    System.out.println(findKthLargest(arr, k));
  }

  public static int findKthLargest(int[] nums, int k) 
	{
    // your code here
		PriorityQueue<Integer> que = new PriorityQueue<>((a, b) -> b - a);

	for(int ele : nums)
	{
		que.add(ele);
	}

	int ct = 0;
	while(que.size()!=0)
		{
			int re = que.remove();
			ct++;
			if(ct==k) return re;
		}
	return -1;
  }
}