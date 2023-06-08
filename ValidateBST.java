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

class ValidateBST 
{
    static Node treeBuilder(String str){  
        if(str.length()==0 || str.charAt(0)=='-'){
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
            if(!currVal.equals("-1")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;
            currVal = ip[i];
            if(!currVal.equals("-1")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    
  public static void main (String[] args) throws IOException
	{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          int t=Integer.parseInt(br.readLine());
          while(t > 0)
		  {
              String s = br.readLine();
            Node root = treeBuilder(s);
              Solution g = new Solution();
              if(g.isBST(root))
              System.out.println("true");
          else
              System.out.println("false");
                t--;
        }
    }
  
}

class pair
	{
		boolean isbst;
		int min;
		int max;

		
		pair(boolean isbst , int min , int max)
		{
			this.isbst = isbst;
			this.min = min;
			this.max = max;
		}

		
	}
class Solution
{

	public pair find(Node node)
	{
		if(node==null)
		{
			return new pair(true , Integer.MAX_VALUE , Integer.MIN_VALUE);
		}

		pair left = find(node.left);
		pair right = find(node.right);

		boolean check = left.isbst && right.isbst && node.data>left.max && node.data<right.min;
		if(check==false)
		{
			return new pair(false , 0 , 0);
		}

		int min = Math.min(node.data , left.min);
		int max = Math.max(node.data , right.max);

		return new pair(true , min , max);
	}
    boolean isBST(Node node)
	{
       // Your Code Here
		pair tej = find(node);
		return tej.isbst;
       
    }
}
