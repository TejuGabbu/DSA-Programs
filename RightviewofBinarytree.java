
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
	
    Node(int data)
	{
        this.data = data;
        left=null;
        right=null;
    }
}


class RightviewofBinarytree 
{
    static Node buildTree(String str)
	{
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
			String s = br.readLine();
			Node root = buildTree(s);
			Solution tree = new Solution();
			ArrayList<Integer> arr = tree.rightView(root);
			for(int x : arr)
			System.out.print(x +" ");
			System.out.println();  
		}
	}
}
  


class Solution
{
    ArrayList<Integer> rightView(Node root) 
	{
		ArrayList<Integer> tej = new ArrayList<>();
		if(root==null)
		{
			return tej;
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(root);

		while(q.size()!=0)
			{
				int size = q.size();
				int rightmost = 0;

				while(size > 0)
					{
						Node right = q.remove();
						rightmost = right.data;
						if(right.left!=null)
						{
							q.add(right.left);
						}
						if(right.right!=null)
						{
							q.add(right.right);
						}
						size--;
					}
				tej.add(rightmost);
			}
		return tej;
    }
}

