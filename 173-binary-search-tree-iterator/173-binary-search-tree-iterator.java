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
class BSTIterator {
    Stack<TreeNode> st = null;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        partialInorder(root);
    }
    private void partialInorder(TreeNode cur) {
        while(cur!=null) {
            st.push(cur);
            cur = cur.left;
        }
    }
    
    public int next() {
        TreeNode cur = st.pop();
        partialInorder(cur.right);
        return cur.val;
    }
    
    public boolean hasNext() {
        if(st.isEmpty()==false)
            return true;
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */