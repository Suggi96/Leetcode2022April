/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode cur = head;
        while(cur!=null) {
            st.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while(!st.isEmpty()) {
            int data = st.pop();
            if(data!=cur.val) return false;
            cur = cur.next;
        }
        return true;
    }
}