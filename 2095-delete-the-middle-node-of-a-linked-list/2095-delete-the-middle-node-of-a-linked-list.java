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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, prev = null;
        int count = 0;
        while(cur!=null) {
            count++;
            cur = cur.next;
        }
        cur = head; prev = dummy;
        for(int i=0;i<count/2;i++) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return dummy.next;
    }
}