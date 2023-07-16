import java.util.*;
import java.io.*;
class Solution 
{
   public List<List<Integer>> fourSum(int[] a, int target) 
	{
       // Write your code here
		Arrays.sort(a);
		List<List<Integer>> tej = new ArrayList<>();
		int i = 0;
		int n = a.length-1;
		while(i<n)
			{
				int j = i+1;
				while(j<n)
					{
						int l = j+1;
						int r = n;
						int ntarget = target-(a[i]+a[j]);
						while(l<r)
							{
								int sum = a[l]+a[r];
								if(sum==ntarget)
								{
									List<Integer> temp = new ArrayList<>();
									temp.add(a[i]);
									temp.add(a[j]);
									temp.add(a[l]);
									temp.add(a[r]);
									tej.add(temp);

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
								else if(sum>ntarget)
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
						int prevj = a[j];
						while(j<n && prevj==a[j])
							{
								j++;
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

public class 4Sum
{
	    
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);

      
        for(int i= 0; i<res.size(); i++){
           Collections.sort(res.get(i));
        }

     
        Collections.sort(res, new Comparator<List<Integer>>() {
               public int compare(List<Integer> frst, List<Integer> scnd) {
                    int i=0;
                    while(frst.get(i)==scnd.get(i)) i++;
                    return frst.get(i)-scnd.get(i);
                    }
                });

        for(int i=0; i<res.size(); i++){   
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            } 
            System.out.println("");
        }
        sc.close();
	}
}