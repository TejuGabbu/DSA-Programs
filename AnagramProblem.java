import java.util.*;

class Solution 
{
	public static boolean check(LinkedHashMap<Character , Integer> wmap , LinkedHashMap<Character , Integer> map)
	{
		for(char c : wmap.keySet())
			{
				if(map.containsKey(c)==false) 
				{
					return false;
				}

				if(map.get(c)!=wmap.get(c)) 
				{
					return false;
				}
					
			}
		return true;
	}
    public static int countAnagrams(String s, String word)
    {
        // Your code here
		LinkedHashMap<Character , Integer> wmap = new LinkedHashMap<>();
		for(int i = 0 ; i<word.length() ; i++)
			{
				char c = word.charAt(i);
				wmap.put(c , wmap.getOrDefault(c , 0)+1);
			}

		int si = 0 ;
		int ei = 0;
		int n = s.length();
		int ct = 0;
		LinkedHashMap<Character , Integer> map = new LinkedHashMap<>();
		int k = word.length();
		while(ei<n)
			{
				char ch = s.charAt(ei);
				map.put(ch , map.getOrDefault(ch , 0)+1);
				int len = ei - si + 1;
				if(len==k)
				{
					if(check(wmap, map)==true)
					{
						ct++;
					}
						char c  = s.charAt(si);
						map.put(c , map.get(c)-1);
						if(map.get(c)==0)
						{
							map.remove(c);
						}
					si++;
				}
				ei++;
			}
		return ct;
			
    } 
}

public class AnagramProblem 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        text = sc.next();
        String word;
        word = sc.next();
        Solution Obj = new Solution();
        System.out.println(Obj.countAnagrams(text, word));
    }
}