import java.util.*;
import java.io.*;

class Node{
    int val;
    Node left, right;
    Node(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
class BST{
    Node root = null;
    BST(){

    }
    Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
}

public class Leftviewofbinarytree {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        BST t = new BST();
        for(int i = 0; i < n; i++){
            t.root = t.insert(t.root, input.nextInt());
        }
        
        Solution Accio=new Solution();
        Accio.letfView(t.root);
    }
}

class Solution
{
    public static void letfView(Node root)
    {
        // Your code here
		if(root==null)
		{
			return;
		}
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int flag = 1;
		while(q.size()!=0)
			{
				int size = q.size();
				int leftmost = 0;
				flag = 1;
				while(size!=0)
					{
						Node del = q.remove();
						if(flag==1)
						{
							leftmost = del.val;
							flag = 0;
						}
						if(del.left!=null)
						{
							q.add(del.left);
						}
						if(del.right!=null)
						{
							q.add(del.right);
						}
						size--;
					}
				System.out.print(leftmost+" ");
			}
		return;
    }
    
}