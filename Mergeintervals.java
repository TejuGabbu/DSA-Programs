import java.util.*;

public class Merge intervals {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> ranges = new ArrayList<>();
        for(int i=0;i<n;i++) {
            ArrayList<Integer> range = new ArrayList<>();
            range.add(sc.nextInt());
            range.add(sc.nextInt());
            ranges.add(range);
        }
		Collections.sort(ranges, new Comparator<ArrayList<Integer>>() {
@Override
public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
return o1.get(0).compareTo(o2.get(0));
}
});
        ArrayList<ArrayList<Integer>> ans = Solution.mergeRanges(ranges);
        int m = ans.size();
        System.out.println(m);
        for(int i=0;i<m;i++) {
            System.out.println(ans.get(i).get(0) + " " + ans.get(i).get(1));
        }
    }
}

class Solution
{
    static ArrayList<ArrayList<Integer>> mergeRanges(ArrayList<ArrayList<Integer>> ranges) 
    {
		int sp = -1;
		int ep = -1;
		ArrayList<ArrayList<Integer>> tej = new ArrayList<>();
		for(int i = 0 ; i<ranges.size() ; i++)
			{
				ArrayList<Integer> temp = ranges.get(i);
				int l = temp.get(0); // 8
				int r = temp.get(1); // 10
				if(i==0 || ep<l)
				{
					sp = l;
					ep = r;
					ArrayList<Integer> t = new ArrayList<>();
					t.add(sp);
					t.add(ep);
					tej.add(t);	
				}
				else
				{
					sp = Math.min(sp , l);
					ep = Math.max(ep , r);
					tej.remove(tej.size()-1);
					ArrayList<Integer> t1 = new ArrayList<>();
					t1.add(sp);
					t1.add(ep);
					tej.add(t1);
				}
				
			}
		return tej;
    }

}