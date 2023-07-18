import java.util.*;

class Solution 
{
	static int solve(String s) 
	{
		// Write your code here
		int si = 0;
		int ei = s.length()-1;
		char f = s.charAt(si);
		char l = s.charAt(ei);
		if(f!=l)
		{
			return s.length();
		}
		int min = Integer.MAX_VALUE;
		int length = 0;
		int flag = 0;
		while(si<ei)
			{
				char f1 = s.charAt(si);
				char l1 = s.charAt(ei);
				if(f1==l1)
				{
					flag = 1;
					char prevc = f1;
					char lastc = l1;
					if(si+1==ei && f1==l1)
					{
						return 0;
					}
					while(si<ei && prevc==s.charAt(si))
						{
							si++;							
						}

					while(si<ei && lastc==s.charAt(ei))
						{
							ei--;
						}
					if(si<ei)
					{
						length = (ei - si)+1;
						min = Math.min(length , min);
					}
				}
				else
				{
					return min;
				}
			}
		if(si==ei)
		{
			return 0;
		}
		if(flag==0)
		{
			return 0;
		}
		return min;
	}
}
public class MinimumLengthofStringAfterDeletingSimilarEnds{
	public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String s = sc.next();
      System.out.println(Solution.solve(s));
   }
}