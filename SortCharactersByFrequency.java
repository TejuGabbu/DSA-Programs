import java.util.*;

class Solution 
{
    public String frequencySort(String s) 
	{
		HashMap<Character , Integer> map = new HashMap<>();
		TreeMap<Integer , ArrayList<Character>> num = new TreeMap<>();
		for(int i = 0 ; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c , 0 )+1);
				
			}

		for(char ele : map.keySet())
			{
				num.put(map.get(ele) , new ArrayList<Character>());
			}
		
		for(char ele : map.keySet())
			{
				int val = map.get(ele);
				num.get(val).add(ele);
			}
		// for(int ele : num.keySet())
		// 	{
		// 		System.out.println(ele + " " + num.get(ele));
		// 	}

		String t = "";
		String temp = "";
		for(int ele : num.keySet())
			{
				ArrayList<Character> t1 = num.get(ele);
				Collections.sort(t1);
				for(char e : t1)
					{
						int s1 = ele;
						while(s1!=0)
							{
								temp = temp + e;
								s1--;
							}
					}
			}

		for(int i = temp.length()-1 ; i>=0 ; i--)
			{
				t = t + temp.charAt(i);
			}
		return t;
    }
}

public class SortCharactersByFrequency 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution Obj = new Solution();
        String result = Obj.frequencySort(s);
        System.out.println(result);
        sc.close();
    }
}