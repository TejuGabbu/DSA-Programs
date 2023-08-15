import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*; 


class LongestCycleinaGraph { 
	public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);  
		//System.out.print(s);
		int n;
		n = sc.nextInt();
		int store[] = new int[n];
		for(int i=0;i<n;i++)
		{
			store[i] = sc.nextInt();
		}
		Solution answer = new Solution();
		System.out.println(answer.longestCycle(store));   
	}
}



class Solution {  
	public int longestCycle(int[] edges)
	{
		   //your code here
		int n = edges.length;
		int lon = -1;
		boolean vis[] = new boolean[n];
		int memo[] = new int[n];
		Arrays.fill(memo , 0);
		for(int start =  0 ; start<n ; start++)
			{
				if(!vis[start])
				{
					int slow = start , fast = start;
					while(edges[fast]!=-1 && edges[edges[fast]]!=-1)
						{
							slow = edges[slow];
							fast = edges[edges[fast]];
							if(slow == fast)
							{
								int cyclelen = 1 ;
								slow = edges[slow];
								while(slow!=fast)
									{
										cyclelen++;
										slow = edges[slow];
									}
								lon = Math.max(lon , cyclelen);
								memo[start] = cyclelen;
								vis[start] = true;
								break;
							}
							if(memo[slow]!=0)
							{
								memo[start] = memo[slow];
								vis[start] = true;
								break;
							}
							
						}
				}
			}
		return lon;
	}
}