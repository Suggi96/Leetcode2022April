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
    TreeNode head = new TreeNode(-1);
    TreeNode ptr = head;
    public TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return ptr.right;
    }
    private void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        head.right = new TreeNode(root.val);
        head = head.right;
        inOrder(root.right);
        return;
    }
}