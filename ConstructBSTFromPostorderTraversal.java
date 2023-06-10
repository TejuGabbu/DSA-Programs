import java.util.Scanner;

public class ConstructBSTFromPostorderTraversal {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
	public static int i = 0;
	public static TreeNode create(int a[] , int l , int r)
	{
		if(i<0)
		{
			return null;
		}

		if(a[i]<l || a[i]>r)
		{
			return null;
		}
		
		TreeNode root = new TreeNode(a[i]);
		i--;
		root.right = create(a,root.val+1,r);
		root.left = create(a,l,root.val-1);
		return root;
	}
    public static TreeNode CreateTree(int n,int[] postOrder) 
	{
        //write code here
		i = postOrder.length-1;
		return create(postOrder, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append("->" + node.val + "<-");
        sb.append((node.right != null ? node.right.val : "."));
        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        TreeNode root = CreateTree(n,post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}