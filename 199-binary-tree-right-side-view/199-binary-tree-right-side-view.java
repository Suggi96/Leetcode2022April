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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        rightView(root, 0, res);
        return res;
    }
    private void rightView(TreeNode root, int curLevel, List<Integer> res) {
        if(root==null)
            return;
        if(curLevel==res.size())
            res.add(root.val);
        
        rightView(root.right, curLevel+1, res);
        rightView(root.left, curLevel+1, res);
    }
}