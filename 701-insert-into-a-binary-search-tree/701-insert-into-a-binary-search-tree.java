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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if(root==null)
            return node;
        TreeNode origRoot = root;
        TreeNode parent = null;
        while(root!=null) {
            parent = root;
            if(val>root.val) {
                root = root.right;
            }
            else {
                root = root.left;
            }
        }
        if(val<parent.val)
            parent.left = node;
        else
            parent.right = node;
        return origRoot;
    }
}