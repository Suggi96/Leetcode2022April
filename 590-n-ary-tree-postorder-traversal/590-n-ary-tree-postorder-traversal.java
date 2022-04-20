/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        post(root, res);
        return res;
    }
    private void post(Node root, List<Integer> res) {
        if(root==null)
            return;
        List<Node> curChildren = root.children;
        for(Node child: curChildren) {
            post(child, res);
        }
        res.add(root.val);
        return;
    }
}