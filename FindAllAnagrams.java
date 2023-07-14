import java.util.*;
import java.io.*;

class Solution 
{
    public List<Integer> findAnagrams(String s, String p) 
	{
		LinkedHashMap<Character,Integer> smap =  new LinkedHashMap<>();
		HashMap<Character,Integer> pmap =  new HashMap<>();
		
		for(int i =  0 ; i<p.length() ; i++)
			{
				char c = p.charAt(i);
				pmap.put(c, pmap.getOrDefault(c  , 0) + 1);
			}

		
		Queue<Character> q = new ArrayDeque<>();
		int n = p.length();  //  p string size // 3

		ArrayList<Integer> tej = new ArrayList<>();
		int si = 0;
		int ei = 0;
		while(ei<s.length())
			{
				char c = s.charAt(ei);
				q.add(c);
				smap.put(c, smap.getOrDefault(c , 0) + 1 );
				if(q.size()==n)
				{
					if(checkequal(pmap , smap)==true)
					{
						tej.add(si);
					}
					
					char re = q.remove();
					smap.put(re , smap.get(re)-1);
					if(smap.get(re)==0)
					{
						smap.remove(re);
					}
					si++;
				}
				ei++;
			}
		return tej;
    }
	public static boolean checkequal(HashMap<Character,Integer> pmap , LinkedHashMap<Character,Integer> smap)
	{
		for(char ele : pmap.keySet())
			{
				if(smap.containsKey(ele)==true && pmap.get(ele)<=smap.get(ele))
				{
					
				}
				else
				{
					return false;
				}
			}
		return true;
	}
}

public class FindAllAnagrams 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        Solution Obj = new Solution();
        List<Integer> res = Obj.findAnagrams(s, p);
        for(int i=0;i<res.size();i++)
            System.out.print(res.get(i) + " ");        
        System.out.println('\n');
    }
}