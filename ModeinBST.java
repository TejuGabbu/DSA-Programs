import java.util.*;

class Solution
{
	public void find(TreeNode root , HashMap<Integer, Integer> map)
	{
		if(root==null)
		{
			return ;
		}

		map.put(root.val , map.getOrDefault(root.val , 0 )+1);
		find(root.left , map);
		find(root.right , map);
		return;
	}
    public int[] FindModes(TreeNode root)
	{
		HashMap<Integer , Integer> map = new HashMap<>();
		find(root , map);
		int max = Integer.MIN_VALUE;
		for(int ele : map.keySet())
			{
				if(map.get(ele)>max)
				{
					max = map.get(ele);
				}
			}
		ArrayList<Integer> tej = new ArrayList<>();
		int ct = 0;
		for(int ele : map.keySet())
			{
				if(map.get(ele)==max)
				{
					tej.add(ele);
					ct++;
				}
			}
		int a[] = new int[ct];
		for(int i = 0 ; i<ct ; i++)
			{
				a[i] = tej.get(i);
				
			}
		return a;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() { }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode levelOrder(TreeNode root, int value) {
        if (root == null) {
            TreeNode node = new TreeNode(value);
            return node;
        }
        if (value <= root.val)
            root.left = levelOrder(root.left, value);

        else
            root.right = levelOrder(root.right, value);
        return root;
    }

    public TreeNode constructBST(int arr[]) {
        int n = arr.length;
        if (n == 0)
            return null;
        TreeNode root = null;
        for (int i = 0; i < n; i++)
            root = levelOrder(root, arr[i]);
        return root;
    }
}

public class ModeinBST 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splited = s.split("\\s+");
        int n = splited.length;
        int[] input = new int[n];
        for (int i = 0; i < n; i++)
            input[i] = Integer.parseInt(splited[i]);
        TreeNode root = new TreeNode();
        root = root.constructBST(input);

        Solution ob = new Solution();
        int[] ans = ob.FindModes(root);
        Arrays.sort(ans);
        for(int a: ans)
            System.out.print(a + " ");
    }
}
