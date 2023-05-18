import java.util.;
import java.io.;

public class ReverseFirstKelementsofQueue
{
    public static void main(String args[]) 
	{
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        QueueInteger q = new LinkedList();
        for(int i = 0; i  n; i++)
		{
            q.add(input.nextInt());
        }
         write code here
		StackInteger st  = new Stack();
		QueueInteger q1 = new ArrayDeque();
		int r = 0;
		r = n-k;  5 - 3 = 2
		r = n - r;  5 - 2 = 3
		int ct = 0 ;
		while(ct!=r)
			{
				st.push(q.remove());
				ct++;
			}
		while(q.size()!=0)
			{
				q1.add(q.remove());
			}
		while(st.size()!=0)
			{
				q.add(st.pop());
			}
		while(q1.size()!=0)
			{
				q.add(q1.remove());
			}
        while(q.size()  0)
		{
            System.out.print(q.poll() +  );
        }
    }
}
