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
            ListNode prev = kth.next; //if i set to null linkedlist gets splitted
            ListNode cur = groupPrev.next; //first node in our group
            while(cur!=groupNext) {
                ListNode nextNode = cur.next;
                cur.next = prev;
                prev = cur;
                cur = nextNode;
            }
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