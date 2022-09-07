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
    public String tree2str(TreeNode root) {
        List<String> list = new ArrayList<>();
        preOrder(root, list);
        return formatOutput(list);
    }
    private String formatOutput(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<list.size()-1;i++)
            sb.append(list.get(i));
        return sb.toString();
    }
    private void preOrder(TreeNode root, List<String> list) {
        if(root==null)
            return;
        
        list.add("(");
        list.add(root.val+"");
        
        if(root.left==null && root.right!=null) {
            list.add("()");
        }
        preOrder(root.left, list);
        preOrder(root.right, list);
        
        list.add(")");
    }
}