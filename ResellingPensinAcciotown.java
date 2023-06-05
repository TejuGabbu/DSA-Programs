import java.util.*;
class ResellingPensinAcciotown 
{
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            Node root = null;
            Queue<Node> q = new LinkedList<>();
            while(n-->0){
                int x = sc.nextInt();
                Node node = new Node(x);
                if(root == null){
                    // System.out.println("Setting root to "+x);
                    root = node;
                }
                else if(q.peek().left == null){
                    // System.out.println("Setting left child of "+q.peek().data+" to "+x);
                    q.peek().left = node;
                }
                else{
                    // System.out.println("Setting right child of "+q.peek().data+" to "+x);
                    q.peek().right = node;
                    q.remove();
                }
                
                q.add(node);
            }
            Solution A = new Solution();
            System.out.println(A.binaryTreeDifference(root));

        }
    }
}

class Solution
{ 
	public static int findheight(Node root)
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
    public static int binaryTreeDifference(Node root) 
	{
		HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();
		int height = findheight(root);
		for(int i = 1 ; i<=height ; i++)
			{
				map.put(i,new ArrayList<Integer>());
			}
			int level = 0;
			Queue<Node> q = new ArrayDeque<>();
			q.add(root);
			while(q.size()!=0)
				{
					int size = q.size(); //1
					level++; // 3
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
							size--; // 0
						}
				}
		int sell = 0;
		int buy = 0;

		// for(int ele : map.keySet())
		// 	{
		// 		System.out.println(ele +" "+ map.get(ele));
		// 	}
		for(int ele : map.keySet())
			{
				ArrayList<Integer> tej = map.get(ele);
				if(ele%2!=0)
				{
					for(int i = 0 ; i<tej.size() ; i++)
						{
							if(tej.get(i)!=-1)
							{
								sell = sell + tej.get(i);
							}
						}
				}
				else
				{
					for(int i = 0 ; i<tej.size() ; i++)
						{
							if(tej.get(i)!=-1)
							{
								buy = buy + tej.get(i);
							}
						}
				}
			}
		// System.out.print(sell+" "+buy);
		int result = sell - buy;
		return result;
    }
}


class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}