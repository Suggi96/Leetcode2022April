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
    List<Integer> list = null;
    int ptr;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        ptr = 0;
        inOrder(root, list);
    }
    private void inOrder(TreeNode root, List<Integer> list) {
        if(root==null)
            return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    public int next() {
        int ans = list.get(ptr);
        ptr++;
        return ans;

    }
    
    public boolean hasNext() {
        if(ptr == list.size())
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */