import java.util.*;

public class KReplacementLongestCharacterString
 {

    public static int characterReplacement(int n, int k,String s)
	{
        //write code here
		int si = 0;
		int ei = 0;
		int ans = 0;
		HashMap<Character  , Integer> map = new HashMap<>();
		int repcha = 0;
		while(ei<n)
			{
				char c = s.charAt(ei);
				map.put(c, map.getOrDefault(c,0)+1);
			    repcha = Math.max(repcha, map.get(c));
				int len = ei - si + 1;
				if(len-repcha > k)
				{
					char ch = s.charAt(si);
					map.put(ch , map.get(ch)-1);
					if(map.get(ch)==0) map.remove(ch);
					si++;
				}
				ans = Math.max(ans , ei - si +1);
				ei++;
			}
		return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = characterReplacement(n,k,s);
        System.out.println(ans);
    }
}
