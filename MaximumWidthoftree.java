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
}

class MaximumWidthoftree 
{
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
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Node root = buildTree(s);
        Solution tree = new Solution();
        int ans = tree.solve(root);
        System.out.println(ans);

        sc.close();
    }
}

class Solution 
{
	public int height(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return Math.max(left,right)+1; 
	}
    public int solve(Node root) 
	{
		if(root==null)
		{
			return 0;
		}
		int height = height(root); // 3
		HashMap<Integer, ArrayList<Integer>> map  = new HashMap<>();
		for(int i = 1 ; i<=height ; i++)
			{
				map.put(i,new ArrayList<Integer>());
			}
		Queue<Node> q = new ArrayDeque<>();
		q.add(root);
		int level = 0;
		while(q.size()!=0)
			{
				int size =  q.size(); // 2
				level++; // 2
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
		int max = Integer.MIN_VALUE;
		for(int ele : map.keySet())
			{
				max = Math.max(max,map.get(ele).size());
			}
		return max;
    }
}
