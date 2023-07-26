import java.io.*;
import java.lang.*;
import java.util.*;
class Job 
{
    int id, profit, deadline;
    Job(int x, int y, int z)
	{
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class JobSequencingProblem {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String inputLine[] = br.readLine().trim().split(" ");
    
        int n = Integer.parseInt(inputLine[0]);
        Job[] arr = new Job[n];
        inputLine = br.readLine().trim().split(" ");
        
        //adding id, deadline, profit
        for(int i=0, k=0; i<n; i++){
            arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
        }
        
        Solution ob = new Solution();
        
        //function call
        int[] res = ob.solve(arr, n);
        System.out.println (res[0] + " " + res[1]);
    
    }
}

class Solution
{
    
    int[] solve(Job arr[], int n)
    {
		Arrays.sort(arr , (a,b)->{
			return b.profit  - a.profit;
		});

		boolean ava[] = new boolean[n+1];
		int ct = 0;
		int profit = 0;
		for(Job ele : arr)
			{
				for(int i = ele.deadline ; i>=1 ; i--)
					{
						if(ava[i]==false)
						{
							ava[i] = true;
							ct++;
							profit+=ele.profit;
							break;
						}
					}
			}
		int tej[] = new int[2];
		tej[0] = ct;
		tej[1] = profit;
		return tej;
		
    }
}
