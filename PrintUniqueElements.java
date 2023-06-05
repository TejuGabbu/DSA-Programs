import java.util.*;

class Accio 
{
    public void UniqueElements(int[] a) 
	{
        //Write your code here
		ArrayList<Integer> tej = new ArrayList<>();
		HashMap<Integer , Integer> map = new HashMap<>();
		for(int i = 0 ; i<a.length ; i++)
			{
				map.put(a[i],map.getOrDefault(a[i],0)+1);
			}
		for(int ele : map.keySet())
			{
				if(map.get(ele)==1)
				{
					tej.add(ele);
				}
			}
		Collections.sort(tej);
		for(int i = 0 ; i<tej.size() ; i++)
			{
				System.out.print(tej.get(i)+" ");
			}
		return;
    }
}

public class PrintUniqueElements 
{
    public static void main(    String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Accio Obj = new Accio();
        Obj.UniqueElements(arr);
    }
}
