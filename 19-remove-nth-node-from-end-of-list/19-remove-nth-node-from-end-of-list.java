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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        for(int i=0;i<n;i++)
            fast = fast.next;
        ListNode cur = dummy;
        while(fast!=null) {
            fast = fast.next;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}