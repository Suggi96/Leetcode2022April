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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        Queue<TreeNode> que = new LinkedList<>();
        if(p!=null && q!=null) {
            que.add(p);
            que.add(q);
        }
        while(!que.isEmpty()) {
            TreeNode first = que.poll();
            TreeNode second = que.poll();
            if(first==null && second==null) continue;
            if(first==null || second==null || first.val!=second.val)
                return false;
            que.add(first.left);
            que.add(second.left);
            que.add(first.right);
            que.add(second.right);
        }
        return true;
    }
}