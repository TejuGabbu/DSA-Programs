import java.io.*;
import java.util.*;



class 3Sum {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) 
		{
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) 
			{
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution 
{
    public List<List<Integer>> threeSum(int[] a) 
	{
		Arrays.sort(a);
		List<List<Integer>> tej = new ArrayList<>();
		int n = a.length-1;
		int i = 0;
		while(i<n)
			{
				int l = i+1;
				int r = n;
				int target = 0-a[i];
				while(l<r)
					{
						int sum = a[l]+a[r];
						if(sum==target)
						{
							List<Integer> curr = new ArrayList<>();
							curr.add(a[i]);
							curr.add(a[l]);
							curr.add(a[r]);
							tej.add(curr);

							int prevl = a[l];
							while(l<r && prevl==a[l])
								{
									l++;
								}

							int prevr = a[r];
							while(l<r && prevr==a[r])
								{
									r--;
								}
						}
						else if(sum>target)
						{
							int prevr = a[r];
							while(l<r && prevr==a[r])
								{
									r--;
								}
						}
						else
						{
							int prevl = a[l];
							while(l<r && prevl==a[l])
								{
									l++;
								}
						}
					}
				int previ = a[i];
				while(i<n && previ==a[i])
					{
						i++;
					}
			}
			return tej;				
    }
}