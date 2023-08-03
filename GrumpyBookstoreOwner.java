import java.util.*;

class Solution{
public static int maxSatisfied(int[] customers, int[] grumpy, int k) 
	{
        // Your code here
		int n = customers.length;
		int dsum = 0;
		for(int i = 0 ; i<n ; i++)
			{
				if(grumpy[i]==0) dsum+=customers[i]; 
			}
		int sum = dsum;

		LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
		for(int i =0 ; i<n ; i++)
			{
				if(grumpy[i]==1) map.put(i,customers[i]);
			}

		int j = 0;
		int max = Integer.MIN_VALUE;
		while(j<=n-k)
			{
				int val = j + k - 1; // 2
				dsum = sum;
				for(int ele : map.keySet())
					{
						if(ele<j)
						{
							continue;
						}
						if(ele >=j && ele<=val)
						{
							dsum+=map.get(ele);		
						}
						if(ele>val)
						{
							break;
						}
					}
				max = Math.max(max , dsum);
				j++;
			}
		return max;
	}
}

public class GrumpyBookstoreOwner
 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] customers = new int[n];
        int[] grumpy = new int[n];
        for (int i = 0; i < n; i++) {
            customers[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            grumpy[i] = scan.nextInt();
        }
        int minutes = scan.nextInt();
        scan.close();
        System.out.print(Solution.maxSatisfied(customers, grumpy, minutes));
    }
}
