import java.util.*;

class Solution {
    public String SmallestSubstring(String a, String b) 
	{
        // Write your code here
		int si = 0;
		int ei = 0;
		int n = a.length();
		HashMap<Character , Integer> bmap = new HashMap<>();
		for(int i = 0 ; i<b.length() ; i++)
			{
				char c = b.charAt(i);
				bmap.put(c, bmap.getOrDefault(c,0)+1);
			}
		HashMap<Character , Integer> amap = new HashMap<>();
		int max = Integer.MAX_VALUE;
		String res = "-1";
		int i = 0;
		while(ei<n)
			{
				char c = a.charAt(ei);
				amap.put(c, amap.getOrDefault(c,0)+1);
				while(check(amap,bmap))
					{
						int len = ei - si +1;
						if(max==len)
						{
							if(si<i)
							{
								i = si;
								res = a.substring(si,ei+1);
							}
						}
						else if(max>len)
						{
							max = len ; // 5
							res = a.substring(si,ei+1); // ciojo
							i = si;
						}
						char ch = a.charAt(si);
						if(bmap.containsKey(ch)) 
						{
							amap.put(ch,amap.get(ch)-1);
							if(amap.get(ch)==0) amap.remove(ch);
						}
						si++;
					}
				ei++;
			}
		return res;

    }
	
	public static boolean check(HashMap<Character , Integer> amap , HashMap<Character , Integer> bmap)
	{
		for(Character ele : bmap.keySet())	
			{
				if(amap.containsKey(ele)==false) return false;
				if(bmap.get(ele)>amap.get(ele)) return false;
			}
		return true;
	}
}

public class SmallestSubstringwithallCharacters
 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
	    Solution Obj = new Solution();
        System.out.println(Obj.SmallestSubstring(a, b));
    }
}