import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} class ConvertBSTtoMinHeap {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node''''s value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    private static void preOrder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

    
        String s = br.readLine();
        Node root = buildTree(s);
        Node duplicate = buildTree(s);

        Solution g = new Solution();

        root = g.convertToMinHeap(root);
        
        preOrder(root);
    }
}

class Solution {
    static void inorder(Node root , ArrayList<Integer> pre)
	{
		if(root==null)
		{
			return;
		}
		inorder(root.left , pre);
		pre.add(root.data);
		inorder(root.right , pre);
		return;
	}
    static Node convertToMinHeap(Node root)
    {
        // Write your code here
		ArrayList<Integer> pre = new ArrayList<>();
		inorder(root , pre);
		Node r = contruct(root , pre);
		return r;
    }
	static int i = 0;
	public static Node contruct(Node root , ArrayList<Integer> pre)
	{
		if(root==null)
		{
			return null;
		}
		int val = pre.get(i);
		i++;
		Node nn = new Node(val);
		nn.left = contruct(root.left , pre);
		nn.right = contruct(root.right , pre);
		return nn;
	}
}
