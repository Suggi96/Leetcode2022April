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
    TreeNode prev, first, middle, last;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        //case 1: if swapped nodes are not adjacent
        if(first!=null && last!=null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        //case 2: if swapped nodes are adjacent
        else if(first!=null && middle!=null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
    private void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        //incorrect arrangement ie not in ascending order
        if(prev!=null && root.val<prev.val) {
            //first node out of place
            if(first==null) {
              first = prev;
              middle = root;  
            }
            //second node out of place
            else {
                last = root;
            }
        }
        prev = root; //store the cur processed node as prev. Useful in next recursion 
        inOrder(root.right);
    }
}