import java.util.*;

class Solution {
    public static int solve(List<List<Integer>> A) 
	{
		Collections.sort(A , (a,b)->{
			return a.get(0) - b.get(0); 
		});

		int psp = -1;
		int pep = -1;
		int ct = 0;
		for(List<Integer> ele : A)
			{
				int csp = ele.get(0);
				int cep = ele.get(1);
				if(pep<csp) // non overlapping
				{
					ct++;
					psp = csp;
					pep = cep;
				}
				else // overlapp here
				{
					if(cep<pep)
					{
						psp = csp;
						pep = cep;
					}
				}
			}
		return ct;
	}
}
public class MaximumNon-overlappingIntervals
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<List<Integer>> A = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> interval = Arrays.asList(a, b);
            A.add(interval);
        }
        int ans = Solution.solve(A);
        System.out.println(ans);
    }
}
