import java.util.*;
import java.lang.*;
import java.io.*;

public class NumberofSubstringsContainingAllThreeCharacters 
{
	 public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
	    String s = sc.nextLine();
	    Solution obj= new Solution();
	    System.out.println(obj.numberOfSubstrings(s));
	}
}
class Solution
{
	public static int check(LinkedHashMap<Character, Integer> curr , char a)
	{
		if(curr.containsKey(a))
		{
			return 1;
		}
		return 0;
	}
	public static int numberOfSubstrings(String s) 
	{
		
		LinkedHashMap<Character, Integer> curr = new LinkedHashMap<>();
		int l = 0;
		int r = 0;
		int n = s.length();
		int m = n - 1;
		int ct = 0;
		int f1 = 0;
		int f2 = 0;
		int f3 = 0;
		while(r<n)
			{
				char c = s.charAt(r);
				curr.put(c , curr.getOrDefault(c , 0)+ 1);
				f1 = check(curr,'a');
				f2 = check(curr,'b');
				f3 = check(curr,'c');
				int sum = f1 + f2 + f3;
				if(sum==3)
				{
					int sub = (m - r)+1;
					ct = ct + sub;
					while(curr.size()==3)
						{
							char fro = s.charAt(l);
							curr.put(fro , curr.get(fro)-1);
							if(curr.get(fro)==0)
							{
								curr.remove(fro);
					    	}
							f1 = check(curr,'a');
							f2 = check(curr,'b');
							f3 = check(curr,'c');
							int sum1 = f1 + f2 + f3;
							if(sum1==3)
							{
								int sub1 = (m - r)+1;
								ct = ct + sub1;
							}
							l++;
						}
				}
				r++;
			}
		return ct;
	}
}