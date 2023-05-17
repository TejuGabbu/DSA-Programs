import java.util.*;

class Solution
{
    public void balancedBrackets(String s, int n) 
	{
        // write code here
		Stack<Character> st = new Stack<>();
		int flag = 0;
		for(int i = 0 ; i<n ; i++)
			{
				char f = s.charAt(i);
				if(s.charAt(i)!=')' && s.charAt(i)!='}' && s.charAt(i)!=']')
				{
					st.push(s.charAt(i));
				}
				else
				{
					int t = (int)f; // 
					if(st.size()==0)
					{
						flag = 1;
						break;
					}
					int t1 = (int)st.peek();
					if(t==41 && t1==40)
					{
						st.pop();
						continue;
					}
					else if(t==93 && t1==91)
					{
						st.pop();
						continue;
					}
					else if(t==125 && t1==123)
					{
						st.pop();
						continue;
					}
					flag = 1;
					break;
				}
			}
		if(flag==1 || st.size()!=0)
		{
			System.out.print("NO");
		}
		else 
		{
			System.out.print("YES");
		}
    }
}

public class BalancedBracekets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        Solution Obj = new Solution();
        Obj.balancedBrackets(s, n);
    }
}