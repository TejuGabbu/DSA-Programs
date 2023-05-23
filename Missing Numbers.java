import java.util.*;

class Solution 
{
    static void missingNumbers(int n, int a[], int m, int b[]) 
	{
        //Write your code here
		//1. check frequency same or not
		//2. missing is first array 
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int ele : a)
			{
				map.put(ele,map.getOrDefault(ele,0)+1);
			}

		
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for(int ele : b)
			{
				map1.put(ele,map1.getOrDefault(ele,0)+1);
			}

		ArrayList<Integer>  tej = new ArrayList<>();
		for(int key : map1.keySet())
			{
				if(map.containsKey(key)==false)
				{
					tej.add(key);
				}
				else
				{
					if(map.get(key)!=map1.get(key))
					{
						tej.add(key);
					}
				}
			}
		if(tej.size()==0)
		{
			System.out.print(-1);
			return;
		}
		Collections.sort(tej);
		for(int i : tej)
			{
				System.out.print(i+" ");
			}
		return;
    }
}

public class MissingNumbers 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        int m = sc.nextInt();
        int brr[] = new int[m];
        for(int i=0; i<m; i++){
            brr[i]= sc.nextInt();
        }

        Solution Obj = new Solution();
        Obj.missingNumbers(n,arr,m,brr);
    }
}