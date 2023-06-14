import java.util.*;

class Solution {
    public ArrayList<Integer> FindIndices(String s, String b) 
	{
		ArrayList<Integer> tej = new ArrayList<>();
		if(b.length()>s.length())
		{
			tej.add(-1);
			return tej;
		}

		int st = -1;
		for(int i = 0 ; i<s.length() ; i++)
			{
				char c = s.charAt(i);
				if(c==b.charAt(0))
				{
					int p = i;
					int k = 0;
					int n = b.length()-1;
					st = i+1;
					while( n>=0 && p!=s.length() && s.charAt(p)==b.charAt(k) )
						{
							p++;
							k++;
							n--;
						}
					if(n<0)
					{
						tej.add(st);
					}
				}
			}
		if(tej.size()==0)
		{
			tej.add(-1);
			return tej;
		}
		return tej;
    }
}

public class SearchPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}