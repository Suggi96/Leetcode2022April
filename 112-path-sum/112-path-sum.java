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
    public boolean hasPathSum(TreeNode root, int targetSum) {
         boolean[] found = {false};
         dfs(root, 0, targetSum, found);
         return found[0];
        
    }
    private void dfs(TreeNode root, int sum, int targetSum, boolean[] found) {
        if(root==null) 
            return;
        if(root.left==null && root.right==null && (sum += root.val)==targetSum) {
            found[0] = true;
        }
        
        dfs(root.left, sum+root.val, targetSum, found);
        dfs(root.right, sum+root.val, targetSum, found);
        
    }
}