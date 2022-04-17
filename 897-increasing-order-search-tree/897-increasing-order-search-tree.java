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
    TreeNode cur = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        TreeNode dummy = new TreeNode(0);
        cur = dummy;
        inOrder(root);
        return dummy.right;
    }
    private void inOrder(TreeNode node) {
        if(node==null)
            return;
        inOrder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inOrder(node.right);
    }
}