import java.util.*;
import java.lang.*;
import java.io.*;


class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Leafatsamelevel
{
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node''s value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }


    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String s = br.readLine();
        Node root = buildTree(s);
    
        Solution g = new Solution();
        boolean b = g.check(root);
        if(b == true)
            System.out.println(1);
        else
            System.out.println(0);
    
    }
}

class Solution
{
    public int findheight(Node root)
	{
		if(root==null)
		{
			return 0;
		}

		int left = findheight(root.left);
		int right = findheight(root.right);

		int all = Math.max(left,right)+1;
		return all;
	}
	public void find(Node root , HashMap<Integer , ArrayList<Integer>> map , int h)
	{
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int level = 0;
		while(q.size()!=0)
			{
				int size = q.size();
				level++;
				while(size!=0)
					{
						Node re = q.remove();
						map.get(level).add(re.data);

						if(re.left!=null)
						{
							q.add(re.left);
						}

						if(re.right!=null)
						{
							q.add(re.right);
						}
						size--;
					}
			}
		return;
	}
	public int findnodes(Node root)
	{
		if(root==null)
		{
			return 0;
		}

		if(root.left == null && root.right == null)
		{
			return 1;
		}

		int left = findnodes(root.left);
		int right = findnodes(root.right);
		return left + right;
	}
    boolean check(Node root)
    {
	    // Your code here	
		if(root==null)
		{
			return false;
		}
		int h = findheight( root);
		int numberofleftnodes = findnodes(root);
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
		
		for(int i = 1; i<=h ; i++)
			{
				map.put(i,new ArrayList<Integer>());
			}
		find(root,map,h);
		if(map.get(h).size()!=numberofleftnodes)
		{
			return false;
		}
		return true;
    }
}
