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
class Solution {
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode root, int prevMax) {
        if(root==null)
            return 0;
        prevMax = Math.max(prevMax, root.val);
        if(root.val>=prevMax) 
         return 1 + dfs(root.left, prevMax) + dfs(root.right, prevMax);
        else
          return dfs(root.left, prevMax) + dfs(root.right, prevMax);
    }
}