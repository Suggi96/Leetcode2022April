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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        rootToleaf(root, Integer.toString(root.val), ans);
        return ans;
    }
    private void rootToleaf(TreeNode root, String s, List<String> ans) {
        if(root.left==null && root.right==null) {
            ans.add(s);
            return;
        }
        if(root.left!=null)
            rootToleaf(root.left, s + "->" + Integer.toString(root.left.val), ans);
        if(root.right!=null)
            rootToleaf(root.right, s + "->" + Integer.toString(root.right.val), ans);
        return;
        
    }
}