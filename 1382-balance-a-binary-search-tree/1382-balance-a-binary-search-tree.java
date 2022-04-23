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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return balancedTree(list, 0, list.size()-1);
    }
    private TreeNode balancedTree(List<Integer> list, int s, int e) {
        if(s>e)
            return null;
        int m = s + (e-s)/2;
        TreeNode node = new TreeNode(list.get(m));
        node.left = balancedTree(list, s, m-1);
        node.right = balancedTree(list, m+1, e);
        return node;
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return;
    }
}