import java.io.*;
import java.util.*;

class Solution
{
    boolean expBalanced(String s)
	{
        // write code here
		Stack<Character> st = new Stack<>();
		for(int i = 0 ; i<s.length() ; i++)
			{
				char f = s.charAt(i);
				if(s.charAt(i)!='}' && s.charAt(i)!=']' && s.charAt(i)!=')')
				{
					st.push(s.charAt(i));
				}
				else
				{
					if(st.size()==0)
					{
						return false;
					}
					int t = (int)f;
					int t1 = (int)st.peek();
					if(t==41)
					{
						while(st.peek()!='(')
							{
								st.pop();
							}
						st.pop();
					}
					else if(t==93)
					{
						while(st.peek()!='[')
							{
								st.pop();
							}
						st.pop();
					}
					else if(t==125)
					{
						while(st.peek()!='{')
							{
								st.pop();
							}
						st.pop();
					}
						
				}
				
			}
		if(st.size()>0)
		{
			return false;
		}
		return true;
		
    }
}

public class Balanced {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}