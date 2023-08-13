import java.util.*;

class Solution {
    static int countEqualSubarray012(int arr[], int n)
    {
        //Write your code here
        int ans = 0;
		int c0 = 0 ;
		int c1 = 0 ;
		int c2 = 0 ;
		String key = (c1-c0)+"#"+(c2-c1);
		HashMap<String , Integer> map = new HashMap<>();
		map.put(key,1);
		for(int i = 0 ; i<n ; i++)
			{
				if(arr[i]==0) c0++;
				if(arr[i]==1) c1++;
				if(arr[i]==2) c2++;
				key = (c1-c0)+"#"+(c2-c1);
				if(map.containsKey(key))
				{
					ans+=map.get(key);
					map.put(key , map.get(key)+1);
				}
				else
				{
					map.put(key,1);
				}
			}
		return ans ;
         
    }   

}

public class CountSubarraysWithEqual0s1sand2s
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
    

        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= sc.nextInt();
        }
        
        Solution Obj = new Solution();
        System.out.println(Obj.countEqualSubarray012(arr,N));

    }
}