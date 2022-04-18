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
    Set<Integer> s = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null && root.right==null)
            return -1;
        inOrder(root);
        if(s.size()<2)
            return -1;
        int res = 0, i=0;
        // for(int val: s)
        //     System.out.println(val);
        
        for(int val: s) {
            if(i<2) {
                res = val;
            }
            else {
                break;
            }
            i++;
        }
            
        return res;
    }
    private void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        s.add(root.val);
        inOrder(root.right);
    }
}