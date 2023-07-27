import java.util.*;
import java.lang.*;
import java.io.*;
class HuffmanEncoding
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine().trim();
        int N = S.length();
        Solution ob = new Solution();
        String[] element = br.readLine().trim().split("\\s+");
        int[] f = new int[N];
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(element[i]);
        }
        ArrayList<String> res  = ob.huffmanCodes(S,f,N);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i)+" ");
        }
        System.out.println();
    
	}
}

class Solution 
{
	public class huffnode
		{
			char c;
			int val;
			huffnode left;
			huffnode right;

			huffnode(char c , int val)
			{
				this.c = c;
				this.val = val;
			}
		}
    public ArrayList<String> huffmanCodes(String s, int f[], int N)
    {
        // Code here
        PriorityQueue<huffnode> q = new PriorityQueue<>((a,b)->{
			return a.val < b.val ? -1 : 1 ; 
		});
		
		for(int i = 0 ; i<N ; i++)
			{
				q.add(new huffnode(s.charAt(i),f[i]));
			}

		while(q.size()>1)
			{
				huffnode f1 = q.remove();
				huffnode s1 = q.remove();
				huffnode nn = new huffnode('*' , f1.val+s1.val);
				nn.left = f1;
				nn.right = s1;
				q.add(nn);
			}
		huffnode root = q.remove();
		ArrayList<String> pre = new ArrayList<>();
		chekc(root , pre , "");
		return pre;
    }
	public void chekc(huffnode root , ArrayList<String> pre , String psf)
	{
		if(root.left==null && root.left==null)
		{
			pre.add(psf);
			return;
		}
		chekc(root.left , pre , psf+"0");
		chekc(root.right , pre , psf+"1");
	}
    
}