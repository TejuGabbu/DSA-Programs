import java.util.*;

class Solution 
{
    public List<Integer> findSubstring(String s, String[] words) 
	{
		HashMap<String , Integer> wordmap = new HashMap<>();
		HashMap<Character , Integer> map = new HashMap<>();
		int len = 0;
		for(int i = 0 ; i<words.length ; i++)
			{
				String ele = words[i];
				len = ele.length();
				wordmap.put(ele , wordmap.getOrDefault(ele,0)+1);
				char c = ele.charAt(0);
				map.put(c,map.getOrDefault(c,0) + 1);
			}
		len = len * words.length; // 6 
		int eachlen = words[0].length(); // 3
		List<Integer> res = new ArrayList<>();
		
		for(int i = 0 ; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				if(map.containsKey(c))
					{
						HashMap<String , Integer>	 tmap = new HashMap<>();
						if(i+len>=s.length())
						{
							continue;
						}
						String d = s.substring(i,i+len);
						int j = i;
						int lim = j+len;
						while(j<s.length() && j < lim)
							{
								String p = s.substring(j,j+eachlen);
								tmap.put(p,tmap.getOrDefault(p,0)+1);
								j = j + eachlen;
							}
						if(check(wordmap , tmap)==true) res.add(i); 
					}
			}
		return res;
		
		
    }
	public static boolean check(HashMap<String , Integer> wordmap , HashMap<String , Integer> tmap)
	{
		for(String ele : wordmap.keySet())
			{
				if(!tmap.containsKey(ele)) return false;
				if(wordmap.get(ele)!=tmap.get(ele)) return false;
			}
		return true;
	}
}

public class SubstringwithConcatenationofAllWords
 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
