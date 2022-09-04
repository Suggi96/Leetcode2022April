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
    public boolean isBalanced(TreeNode root) {
        boolean[] flag = {true};
        dfs(root, flag);
        return flag[0];
    }
    private int dfs(TreeNode root, boolean[] flag) {
        if(root==null)
            return 0;
        if(flag[0]!=false) {
            int lh = dfs(root.left, flag);
            int rh = dfs(root.right, flag);
            int curh = Math.abs(lh - rh);
            if(curh>1)
                flag[0] = false;
            return 1 + Math.max(lh, rh);
        }
        return 0;
        
    }
} 