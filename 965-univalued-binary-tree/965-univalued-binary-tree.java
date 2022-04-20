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
    boolean equal = true;
    public boolean isUnivalTree(TreeNode root) {
        check(root);
        return equal;
    }
    private void check(TreeNode root) {
        if(root==null)
            return;
        if(root.left!=null) {
            if(root.val==root.left.val)
                check(root.left);
            else {
                equal = false;
                return;
            }
        }
        if(root.right!=null) {
            if(root.val==root.right.val) 
                check(root.right);
            else {
                equal = false;
                return;
            }
        }
    }
}