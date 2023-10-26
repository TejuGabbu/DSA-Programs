import java.util.*;

class Accio {
    public static int solve(int[] a, int k) 
	{
        //Your code goes here
		return t(a , k) - t(a , k-1);
    }
	public static int t(int a[] , int k)
	{
		int si = 0;
		int ei = 0;
		int n = a.length;
		HashMap<Integer , Integer> map = new HashMap<>();
		int ct = 0;
		while(ei<n)
			{
				map.put(a[ei]  , map.getOrDefault(a[ei] , 0) + 1);
				while(map.size()>k)
					{
						int re = a[si];
						map.put(re , map.get(re)-1);
						if(map.get(re)==0) map.remove(re);
						si++;
					}
				ct+= ei - si+1;
				ei++;
			}
		return ct;
	}
}

public class Main {  
  public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
	    
	    int n = sc.nextInt();
		int[] a = new int[n];
    	for(int i=0;i<n;i++)
		{
			a[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		Accio Obj = new Accio();
        System.out.println(Obj.solve(a, b));
        sc.close();
	}
}