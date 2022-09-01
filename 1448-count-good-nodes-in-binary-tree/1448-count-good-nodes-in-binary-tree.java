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
        int[] ans = {0};
        dfs(root, Integer.MIN_VALUE, ans);
        return ans[0];
    }
    private void dfs(TreeNode root, int curMax, int[] ans) {
        if(root==null)
            return;
        
        if(root.val>=curMax) {
            curMax = root.val;
            ans[0]++;
        }
        
        dfs(root.left,curMax,ans);
        dfs(root.right,curMax,ans);
    }
}