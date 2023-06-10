import java.util.Scanner;

public class ConstructBSTFromPreorderTraversal {
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
		if(i==a.length)
		{
			return null;
		}
		if(a[i]<l || a[i]>r)
		{
			return null;
		}
		
		TreeNode nn = new TreeNode(a[i]);
		i++;
		nn.left = create(a,l,nn.val-1);
		nn.right = create(a,nn.val+1,r);
		return nn;
	}
    public static TreeNode CreateTree(int n,int[] preOrder) 
	{
		return create(preOrder , Integer.MIN_VALUE , Integer.MAX_VALUE);
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = CreateTree(n,pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}