/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public int sumRootToLeaf(TreeNode root) 
    {
        int sum = 0;
        return findnumber(root , "",sum);
    }
    public int findnumber(TreeNode root , String nsf , int sum)
    {
        if(root==null)
        {
            return 0 ;
        }

        nsf+=root.val;
        if(root.left==null && root.right ==null)
        {
            int value = Integer.parseInt(nsf,2);
            return value;
        }
        int left = findnumber(root.left , nsf, sum);
        int right =findnumber(root.right , nsf, sum);
        return left + right;
    }
}