import java.util.*;

public class DistinctCharacterSubstring
 {

    public static long DistinctCharacterSubstring(String s)
	{
        //write code here
		long ct = 0;
		HashMap<Character , Integer> map = new HashMap<>();
		int si = 0;
		int ei = 0;
		int n = s.length();
		while(ei<n)
			{
				char c = s.charAt(ei);
				map.put(c, map.getOrDefault(c,0)+1);
				while(map.get(c)>1)
					{
						char ch = s.charAt(si);
						map.put(ch , map.get(ch)-1);
						if(map.get(ch)==0) map.remove(ch);
						si++;
					}
				ct+=ei-si+1;
				ei++;
			}
		return ct;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long ans = DistinctCharacterSubstring(s);
        System.out.println(ans);
    }
}
