import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class MinimumDepthofBinaryTree {
    static Node buildTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if (i >= ip.length)
                break;
            currVal = ip[i];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution g = new Solution();
        sc.close();
        int ans = g.minimumDepth(root);
		System.out.print(ans);
        // Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
        //     public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        //         int result = 0;
        //         for (int i = 0; i <= list1.size() - 1 && result == 0; i++) {
        //             result = list1.get(i).compareTo(list2.get(i));
        //         }
        //         return result;
        //     }
        // });
        // for (int i = 0; i < ans.size(); i++) {
        //     for (int j = 0; j < ans.get(i).size(); j++) {
        //         System.out.print(ans.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution 
{
    public int minimumDepth(Node root) 
	{
        //write code here
		if (root == null)
            return 0;
 
        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;
 
        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;
 
        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;
 
        return Math.min(minimumDepth(root.left),
                        minimumDepth(root.right)) + 1;
    }
}