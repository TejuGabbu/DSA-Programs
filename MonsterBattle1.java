import java.util.*;
import java.io.*;

public class MonsterBattle1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        int[] health = new int[n];
        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            health[i] = Integer.parseInt(line[i]);
        }
        Solution ob = new Solution();
        System.out.println(ob.minAttacksNeeded(health, k));
    }
}

class Solution 
{
	static class soldier
		{
			int health;
			boolean isking;

			soldier(int health , boolean isking)
			{
				this.health = health;
				this. isking = isking;
			}
		}
    public static int minAttacksNeeded(int[] health, int k) 
	{
		Queue<soldier> q = new ArrayDeque<>();
		for(int i = 0 ; i< health.length; i++)
			{
				if(i==k)
				{
					q.add(new soldier(health[i],true));
				}
				else
				{
					q.add(new soldier(health[i],false));
				}
			}
		int attacks = 0;
		while(true)
			{
				soldier t = q.remove();
				attacks++;
				t.health = t.health - 1;
				if(t.health == 0)
				{
					if(t.isking == true)
					{
						return attacks;
					}
				}
				else
				{
					q.add(new soldier(t.health , t.isking));
				}
			}
		// return -1;
    }
}