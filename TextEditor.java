import java.io.*;
import java.util.*;
class TextEditor
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int q=sc.nextInt();
        sc.nextLine();
        TextEditor obj=new TextEditor();
        for(int i=0;i<q;i++)
        {
            // String[] s = sc.nextLine().split(" "); 
            String s=sc.nextLine();
            if(s.equals("UNDO"))
            {
                obj.UNDO();
            }
            else if(s.equals("REDO"))
            {
                obj.REDO();
            }
            else if(s.equals("READ"))
            {
               obj.READ();

            }
            else
            {
                char ch=s.charAt(6);
                obj.WRITE(ch);
            }
        }
    }
}

class TextEditor
{
    // your code here
	static Stack<Character> st = new Stack<>();
	static Stack<Character> temp = new Stack<>();
	
    static void WRITE(char X)
    {
		st.push(X);
    }
  
    static void UNDO()
    {
        if(st.size()>0)
		{
			temp.push(st.peek());
			st.pop();
		}
    }
  

    static void REDO()
    {
        if(temp.size()>0)
		{
			st.push(temp.peek());
			temp.pop();
		}
    }

    static void READ()
    {
      // store it in a string the print it
		Stack<Character> st1 = new Stack<>();
		Stack<Character> t = new Stack<>();
		String s = "";
		while(st.size()!=0)
			{
				t.push(st.peek());
				s = s + st.pop();
			}
		while(t.size()!=0)
			{
				st.push(t.pop());
			}
		for(int i = s.length()-1 ; i>=0 ; i--)
			{
				System.out.print(s.charAt(i));
			}
		System.out.print(" ");
    }

}