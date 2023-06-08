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
    Node constructBST(int[] arr, int start, int end, Node root) 
	{
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class TargetSumPairInBst 
{
    public static void main(String[] args) throws Throwable 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}

class Accio 
{
	static int flag = 0;
	public boolean find(Node root , int val)
	{
		if(root==null)
		{
			return false;
		}

		if(root.data<val)
		{
			return find(root.right,val);
		}
		else if(root.data>val)
		{
			return find(root.left,val);
		}
		else
		{
			return true;
		}

	}
	public void target(Node mroot , Node curr , int target )
	{
		if(curr==null)
		{
			return;
		}
    // 100 we have the target
		target(mroot,curr.left,target);
		int val = target - curr.data;
		if(curr.data<val)
		{
			if(find(mroot,val)==true)
			{
				flag = 1;
				System.out.println(curr.data+" "+val);
			}
		}

		target(mroot,curr.right,target);
	}
    public void targetSum(Node root, int tar)
    {
		if(root==null)
		{
			return;
		}
		Node mroot = root;
		Node curr = root;
		target(mroot , curr , tar);
		if(flag ==0)
		{
			System.out.print(-1);
		}
		return;
    }
}