import java.util.*;
import java.io.*;
class pair
	{
		char c ; 
		int ind;
		pair(char c , int ind)
		{
			this.c = c;
			this.ind = ind;
		}
		
	}
class Emilyandletters
 {
    public static int firstUniqChar(String s) 
	{
        // Write your code here
		LinkedHashMap<Character , Integer> map = new LinkedHashMap<>();
		LinkedHashMap<Character , Integer> indmap = new LinkedHashMap<>();
		int n = s.length();
		for(int i = 0 ; i<n ; i++)
			{
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c,0)+1);
				indmap.put(c,i);
			}
		for(char ele : map.keySet())
			{
				if(map.get(ele)==1) return indmap.get(ele);
			}
		return -1;
		
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(firstUniqChar(s));
    }
}