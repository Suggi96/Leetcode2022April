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
    List<Integer> list = new ArrayList<>();
    int i = 0;
    public void recoverTree(TreeNode root) {
        makeList(root);
        Collections.sort(list);
        inOrder(root);
    }
    private void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        root.val = list.get(i++);
        inOrder(root.right);
    }
    private void makeList(TreeNode root) {
        if(root==null)
            return;
        makeList(root.left);
        list.add(root.val);
        makeList(root.right);
    }
}