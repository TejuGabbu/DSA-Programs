import java.util.*;

class Accio 
{
    public long CountPairs(int[] arr, int k) 
	{
        //Write your code here
		HashMap<Integer, Integer> map = new HashMap<>();
        
        long ans = 0;
        for (int i=0;i<arr.length;i++) 
		{
            int rem = arr[i]%k;
            if(rem!=0) 
			{
                int neededRem = k-rem;
                if(map.containsKey(neededRem)) 
				{
                    int frequency = map.get(neededRem);
                    ans+=frequency;
                } 
                map.put(rem , map.getOrDefault(rem , 0 ) +1);
            } 
			else 
			{
                if(map.containsKey(0)) 
				{
                    int freq = map.get(0);
                    ans+=freq;
                } 
                map.put(0, map.getOrDefault(0 , 0 ) +1);
            }
            
        }
        return ans;
    }
}

public class CountArrayPairsDivisiblebyK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }


        Accio Obj = new Accio();
        System.out.println(Obj.CountPairs(arr, k));

    }
}