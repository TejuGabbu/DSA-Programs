import java.util.*;

class Accio
{
    static int PriyankandToys(int n,int[] w)
	{
		Arrays.sort(w);
		int ct = 0;
		int i = 0 ;
		while(i<n)
			{
				int val = w[i]+4;
				int j = i;
				while(j<n && w[j]<=val)
					{
						j++;
					}
				i = j;
				ct++;
			}
		return ct;
    }
}

public class PriyankandToys
 {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for(int i=0;i<n;++i){
            w[i]=sc.nextInt();
        }
        Accio obj = new Accio();
        int ans = obj.PriyankandToys(n,w);
        System.out.println(ans);
    }
}