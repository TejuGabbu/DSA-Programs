import java.util.*;
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree
{
    Node constructBST(int[]arr,int start,int end,Node root)
    {
        if(start>end)
            return null;
        int mid=(start+end)/2;

        if(root==null)
            root=new Node(arr[mid]);

        root.left=constructBST(arr,start,mid-1, root.left);
        root.right=constructBST(arr,mid+1,end, root.right);

        return root;

    }
}

public class LCAofBinarySearchTree {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int arr[]=new int[n];
        for (int i = 0; i < n; i++) 
        {
            arr[i] = sc.nextInt(); 
        }

        Arrays.sort(arr);
        Node root=null;
        BinarySearchTree bst=new BinarySearchTree();
        root=bst.constructBST(arr,0,n-1,root);
            
        Solution Accio = new Solution();
        Node ans=Accio.LCA(root,p,q);
        System.out.println(ans.data);
        sc.close();
        
    }
}

class Solution
{
	public void find(Node root , int tar , ArrayList<Node> pathleft)
	{
		if(root==null)
		{
			return ;
		}

		pathleft.add(root);
		if(root.data<tar)
		{
			find(root.right, tar , pathleft);
		}
		else if(root.data>tar)
		{
			find(root.left,tar,pathleft);
		}
		return;
	}
    Node LCA(Node node, int n1, int n2)
    {
        // Your code here
		
		ArrayList<Node> pathleft = new ArrayList<>();
		find(node , n1 , pathleft);

		
		ArrayList<Node> pathright = new ArrayList<>();
		find(node , n2 , pathright);

		int i = 0;		
		int s1 = pathleft.size();
		int s2 = pathright.size();
		while(s1!=0 && s2!=0 && pathleft.get(i).data == pathright.get(i).data)
			{
				i++;
				s1--;
				s2--;
			}
		return pathleft.get(i-1);
    }
}