import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] envelopes = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            envelopes[i][0] = Integer.parseInt(st.nextToken());
            envelopes[i][1] = Integer.parseInt(st.nextToken());
        }
        Solution s = new Solution();
        System.out.println(s.maxEnvelopes(envelopes));
    }

}

class Solution 
{
    public int maxEnvelopes(int[][] env)
	{
		Arrays.sort(env , (a,b)->{
			if(a[0]==b[0]) return b[1] - a[1];
			return a[0] - b[0];
		});

		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0 ; i<env.length ; i++)
			{
				int h = env[i][1];
				Integer ceil = set.ceiling(h);
				if(ceil!=null) set.remove(ceil);
				set.add(h);
			}
		return set.size();
    }
}