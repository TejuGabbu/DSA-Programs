import java.util.*;

class pair
	{
		int student ; 
		boolean isK ;

		pair(int student , boolean isK)
		{
			this.student = student;
			this.isK = isK;
		}
	}
class Solution 
{
    public int distribution(int n, int a[],int k) 
	{
        // Write your code here
		Queue<pair> q = new ArrayDeque<>();
		for(int i = 0 ; i<a.length ; i++)
			{
				if(i!=k)
				{
					q.add(new pair(a[i],false));
				}
				else
				{
					q.add(new pair(a[i],true));
				}
			}
		int ct = 0;
		while(q.size()!=0)
			{
					ct++;
					int t = --q.peek().student;
					if(t == 0 && q.peek().isK)
					{
						return ct;
					}
					else if(t==0 && q.peek().isK==false)
					{
						q.remove();
					}
					else
					{
						if(q.peek().isK==false)
						{
							q.add(new pair(t,q.peek().isK));
						}
						else
						{
							q.add(new pair(t,q.peek().isK));
						}
						q.remove();
					}
			}
		return ct;
		
    }
}
public class Classchocolatedistribution
{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
         int k = sc.nextInt();
        sc.close();
        Solution Obj = new Solution();
		int a=Obj.distribution(n,arr,k);
        System.out.print(a+" ");
		}
}