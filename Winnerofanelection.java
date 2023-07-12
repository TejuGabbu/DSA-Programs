import java.io.*;

import java.util.*;

class Accio 
{
    static String votes(String arr[],int n)
	{
        TreeMap<String , Integer> map = new TreeMap<>();
		for(int i = 0 ; i<n ; i++)
			{
				map.put(arr[i] , map.getOrDefault(arr[i] , 0 )+1);
			}
		int max = Integer.MIN_VALUE;
		String tej = "";
		for(String ele : map.keySet())
			{
				if(map.get(ele)>max)
				{
					max = map.get(ele);
					tej = ele;
				}
			}
		return tej;
    }
}

public class Winnerofanelection 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.next();
        Accio Obj = new Accio();
        String result = Obj.votes(arr, n);
        System.out.print(result);
    }
}