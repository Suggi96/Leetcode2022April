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
    TreeNode px = null;
    TreeNode py = null;
    int lx = -1;
    int ly = -1;
    public boolean isCousins(TreeNode root, int x, int y) {
        checkCousins(root, null, 0, x, y);
        if(px!=py && lx==ly)
            return true;
        return false;
    }
    private void checkCousins(TreeNode curNode, TreeNode parent, int curLevel, int x, int y) {
        if(curNode==null)
            return;
        if(x==curNode.val) {
            px = parent;
            lx = curLevel;
            return;
        }
        if(y==curNode.val) {
            py = parent;
            ly = curLevel;
            return;
        }
        checkCousins(curNode.left, curNode, curLevel+1, x, y);
        checkCousins(curNode.right, curNode, curLevel+1, x, y);
        return;
    }
}