import java.util.*;
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
class LeafIt
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Node root = null;
            for(int i = 0; i < n; i++)
            {
                int data = sc.nextInt();
                root = insert(root, data);
            }
            Solution solution = new Solution();
            System.out.println(solution.leafIt(root));
    }
    
    public static Node insert(Node root, int x)
    {
        
        if(root == null)
          {
              return (new Node(x));
          }
          
          if(x < root.data)
          {
              root.left = insert(root.left, x);
          }
          else if(x >= root.data)
          {
              root.right = insert(root.right, x);
          }
          
      return root;      
    }
    
}
class Solution
{
    public static int leafIt(Node root)
    {
        //Your code here 
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return root.data;
		}

		int left = leafIt(root.left);
		int right = leafIt(root.right);
		return left + right;
    }
}
