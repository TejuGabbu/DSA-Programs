import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;
import java.lang.*;

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

public class ConstructBstFromLevelorderTraversal {

    static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        Node ans = Obj.bstFromLevel(arr, n);
        printLevelOrder(ans);
        sc.close();
    }
}

class pair
	{
		Node node;
		int l;
		int r;

		pair(Node node , int l , int r)
		{
			this.node = node;
			this.l = l;
			this.r = r;
		}
	}
class Solution 
{
    Node bstFromLevel(int arr[], int n) 
	{
		Queue<pair> q = new ArrayDeque<>();
		Node root = new Node(arr[0]);
		q.add(new pair(root , Integer.MIN_VALUE , root.data-1));
		q.add(new pair(root, root.data+1,Integer.MAX_VALUE));

		int i = 1;
		while(q.size()!=0)
			{
				pair re = q.remove();
				if(i==arr.length)
				{
					continue;
				}

				if(arr[i]<re.l || arr[i]>re.r)
				{
					continue;
				}
					
				Node nn = new Node(arr[i]);
				
				if(nn.data<re.node.data)
				{
					re.node.left = nn;
				}
				else
				{
					re.node.right = nn;
				}

				i++;

				q.add(new pair(nn,re.l , nn.data-1));
				q.add(new pair(nn,nn.data+1 , re.r));
									
			}
		return root;
    }
}