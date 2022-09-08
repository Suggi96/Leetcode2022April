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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy;
        while(true) {
            ListNode kth = getkth(groupPrev, k);
            if(kth==null) break;
            ListNode groupNext = kth.next;
            ListNode prev = kth.next, cur = groupPrev.next;
            while(cur!=groupNext) {
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }
            //adjust groupPrev for next iteration
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }
    private ListNode getkth(ListNode cur, int k) {
        while(cur!=null && k>0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}