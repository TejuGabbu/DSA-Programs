import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []a, int n, int B) 
	{
        // write your code here
		HashSet<Integer> set = new HashSet<>();

		for(int val : a)
			{
				if(set.contains(val-B)==true || set.contains(val+B)==true)
				{
					return 1;
				}
				else
				{
					set.add(val);
				}
			}
		return 0;
    }
}

public class ProblemWithGivenDifference{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
