import java.io.*;
import java.util.*; 

class Celebrity
{
    public static void main(String args[]) throws IOException 
	{ 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M[][] = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                M[i][j] = sc.nextInt();
        System.out.println(new Solution().findCelebrity(M,N));
    } 
} 
class Solution
{ 
    int findCelebrity(int a[][], int n)
    { //  n means same rows and same colums
        Stack<Integer> st = new Stack<>();
		for(int i = 0 ; i<n ; i++)
			{
				st.push(i);
			}
		int f = 0;
		int s = 0;
		while(st.size()!=1)
			{
				f = st.pop();
				s = st.pop();
				
				if(a[f][s]==1)
				{
					st.push(s);	
				}
				else
				{
					st.push(f);
				}
			}
		int cel = st.peek(); // 3 is the celebrity and we want to confirm it 
		//  so go to its row and colums
		
		for(int i = 0 ; i<n ; i++)
			{
				if(cel!=i && a[cel][i]==1)
				{
					return -1;
				}
			}

		for(int i = 0 ; i<n ; i++)
			{
				if(cel!=i && a[i][cel]==0)
				{
					return -1;
				}
			}
		return cel;
    }
}