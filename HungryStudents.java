import java.util.*;

class Solution{
    public static int countStudents(List<Integer> stu, List<Integer> sand )
	{
		Stack<Integer> st = new Stack<>();
		Queue<Integer> q = new ArrayDeque<>();
		int n = stu.size();
		for(int i = n-1 ; i>=0 ; i--)
			{
				st.push(sand.get(i));
			}
		
		for(int i = 0 ; i<n ; i++)
			{
				q.add(stu.get(i));
			}
		int ct = 0;
		while(st.size()!=0)
			{
				if(st.peek()!=q.peek())
				{
					int re = q.remove();
					q.add(re);
					ct++;
				}
				else
				{
					st.pop();
					q.remove();
					ct = 0;
				}
				
				if(ct>=q.size())
				{
					return q.size();
				}
			}
		return q.size();
		
    }
}
public class HungryStudents
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<Integer>students=new ArrayList<>();
        for(int i=0;i<n;i++){
            students.add(sc.nextInt());
        }
        List<Integer>sandwiches=new ArrayList<>();
        for(int j=0;j<n;j++){
            sandwiches.add(sc.nextInt());
        }
        System.out.println(Solution.countStudents(students,sandwiches));
        sc.close();
    }
}