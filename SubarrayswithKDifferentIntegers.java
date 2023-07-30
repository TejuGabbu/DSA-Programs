
import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class SubarrayswithKDifferentIntegers
{
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int subarrayCount(int a[], int N, int k) 
    {
    // code here
    return find(a,k) - find(a,k-1);

  }
  public static  int find(int a[] , int k)
    {
        HashMap<Integer , Integer> map = new HashMap<>();
        int si = 0;
        int ei = 0;
        int n = a.length;
        int ct = 0;
        while(ei<n)
        {
            map.put(a[ei],map.getOrDefault(a[ei],0)+1);
            while(map.size()>k)
            {
                map.put(a[si],map.get(a[si])-1);
                if(map.get(a[si])==0) map.remove(a[si]);
                si++;
            }
            ct+=ei-si+1;
            ei++;
        }
        return ct;
    }
}
     