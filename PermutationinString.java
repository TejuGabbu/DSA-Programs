import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.lang.*; 
class Solution{
	public static void find(String s , HashMap<Character , Integer> map)
	{
		for(int i = 0 ; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				map.put(c , map.getOrDefault(c,0)+1);
			}
		return;
	}
    public static boolean checkInclusion(String s1, String s2) 
	{
        //Write your code here 
		HashMap<Character , Integer> s1map = new HashMap<>();
		find(s1,s1map);
		
		HashMap<Character , Integer> s2map = new HashMap<>();
		int si = 0;
		int ei = 0;
		int n = s2.length();
		int flag = 0;
		while(ei<n)
			{
				char c = s2.charAt(ei);
				if(s1map.containsKey(c)==false)
				{
					ei++;
					si=ei;
					s2map.clear();
					continue;
				}
				else
				{
					s2map.put(c,s2map.getOrDefault(c,0)+1);
				}
				
				if(s1map.size()==s2map.size() && checkequal(s1map , s2map) )
					{
						flag = 1;
						if(checkequal(s1map , s2map)) return true;
						s2map.clear();
					}
				ei++;
				if(flag==1)
				{
					si = ei;
					flag = 0;
				}
			}
		return false;
		
    }
	public static boolean checkequal(HashMap<Character , Integer> s1map , HashMap<Character , Integer> s2map)
	{
		for(char ele : s1map.keySet())
			{
				if(!s2map.containsKey(ele)) return false;
				if(s1map.get(ele)>s2map.get(ele)) return false;
			}
		return true;
	}
}
public class PermutationinString
 {
    public static void main(String args[])throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String s = br.readLine();
         String ip[] = s.split(" ");
        System.out.print(Solution.checkInclusion(ip[0],ip[1]));
    }
}