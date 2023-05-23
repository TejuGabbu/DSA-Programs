import java.util.*;
import java.io.*;

public class OddEvenProblem 
{
	public static String find(String s)
	{
		HashMap<Character , Integer> map = new HashMap<>();
		for(int i = 0 ; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				map.put(c,map.getOrDefault(c,0)+1);
			}
		int odd = 0;
		int even = 0;
		for(char ele : map.keySet())
			{
				int a = ((int)ele) - 96;
				if(a%2==1 && map.get(ele) > 0 && map.get(ele)%2 == 1)
				{
					odd += 1;
				}
				if(a%2==0 && map.get(ele) > 0 && map.get(ele)%2 == 0)
				{
					if(map.get(ele)>0)
					{
						even += 1;
					}
				}
			}
		if((odd+even)%2==0)
		{
			return "EVEN";
		}
		else
		{
			return "ODD";
		}
	}
    public static void main(String args[]) 
	{
        //your code here
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.print(find(s));
    }
}