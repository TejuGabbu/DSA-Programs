import java.util.*;

class Node {

  int data;
  Node left, right;
}

class Solution
{
	public static void leftb(Node root)
	{
		if(root==null)
		{
			return;
		}

		if(root.left==null && root.right==null)
		{
			// left node dont print anything
		}
		else
		{
			System.out.print(root.data+" ");
		}
		
		if(root.left!=null)
		{
			leftb(root.left);
		}
		else
		{
			leftb(root.right);
		}
		return;
	}
	public static void leafb(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		if(root.left==null && root.right==null)
		{
			System.out.print(root.data+" ");
		}
		
		leafb(root.left);
		leafb(root.right);
	}
	public static void rightb(Node root)
	{
		if(root==null)
		{
			return;
		}

		if(root.right!=null)
		{
			rightb(root.right);
		}
		else
		{
			rightb(root.left);
		}

		if(root.left==null && root.right==null)
		{
			// left node dont print anything
		}
		else
		{
			System.out.print(root.data+" ");
		}
		return;
	}
    static void printBoundary(Node root)
    {
        // Your code here
		if(root==null)
		{
			return ;
		}
		System.out.print(root.data+" ");
		leftb(root.left); // left boundry
		leafb(root);
		rightb(root.right); // right boundry
    }
}
public class BoundaryTraversalofBinaryTree {

  static Node getNode(int data) {
    // Allocate memory
    Node newNode = new Node();

    // put in the data
    newNode.data = data;
    newNode.left = newNode.right = null;
    return newNode;
  }

  static Node LevelOrder(Node root, int data) {
    if (root == null) {
      root = getNode(data);
      return root;
    }
    if (data <= root.data) root.left =
      LevelOrder(root.left, data); else root.right =
      LevelOrder(root.right, data);
    return root;
  }

  static Node constructBst(int arr[], int n) {
    if (n == 0) return null;
    Node root = null;

    for (int i = 0; i < n; i++) root = LevelOrder(root, arr[i]);

    return root;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] tree = new int[n];
    for (int i = 0; i < n; i++) tree[i] = sc.nextInt();
    sc.close();
    Node root = constructBst(tree, n);
    Solution.printBoundary(root);
  }
}
