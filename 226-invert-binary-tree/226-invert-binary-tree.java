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
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
    private TreeNode dfs(TreeNode root) {
        if(root==null)
            return root;
        
        if(root.left==null && root.right==null)
            return root;
        
        TreeNode tmp = root.left;
        root.left = dfs(root.right);
        root.right = dfs(tmp);
        
        return root;
    }
}