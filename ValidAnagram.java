import java.util.*;

class Solution 
{
   static boolean areAnagram(String c1, String c2) 
	{
       //Write your code here
		if(c1.length() != c2.length())
		{
			return false;
		}
		
		HashMap<Character , Integer> map = new HashMap<>(); 
		for(int i = 0 ; i <c1.length() ; i++)
			{
				char c = c1.charAt(i);
				map.put(c,map.getOrDefault(c,0)+1);
			}
		
		for(int i = 0 ; i<c2.length() ; i++)
			{
				char c = c2.charAt(i);
				if(map.containsKey(c)==false)
				{
					return false;
				}
				else
				{
					map.put(c,map.get(c)-1);
					if(map.get(c)==0)
					{
						map.remove(c);
					}
				}
			}
		return true;
		
		
    }
}

public class ValidAnagram 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        Solution Obj = new Solution();
        
        if (Obj.areAnagram(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
