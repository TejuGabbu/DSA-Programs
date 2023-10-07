import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] bridges = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bridges[i][0] = Integer.parseInt(st.nextToken());
            bridges[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.maxPossibleBridges(bridges));
    }
}

class pair
	{
		int north;
		int south;

		pair(int n , int s)
		{
			north = n;
			south = s;
		}
	}
class Solution 
{
    public int maxPossibleBridges(int[][] arr) 
	{
		ArrayList<pair> ar = new ArrayList<>();
		int n = arr.length;
		for(int i = 0 ; i<n ; i++)
			{
				ar.add(new pair(arr[i][0] , arr[i][1]));
			}

		Collections.sort(ar , (a,b)->{
			return a.north - b.north;
		});

		return lis(ar);
    }
	public int lis(ArrayList<pair> ar)
	{
		TreeSet<Integer> set = new TreeSet<>();
		for(pair p : ar)
			{
				int south = p.south;
				Integer ceil = set.ceiling(south);
				if(ceil!=null)
				{
					set.remove(ceil);
				}
				set.add(south);
			}
		return set.size();
	}
}