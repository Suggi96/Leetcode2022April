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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode l1 = null, l2=null;        
        ListNode l1head = null, l2head = null;
        
        while(head!=null) {
            if(head.val<x) {
           //     ListNode temp = new ListNode(head.val);
                if(l1head==null) {
                    l1head = head;
                    l1 = head;
                }
                else {
                    l1.next = head;
                    l1 = l1.next;
                }
            }
            else {
              //  ListNode temp = new ListNode(head.val);
                if(l2head==null) {
                    l2head = head;
                    l2 = head;
                }
                else {
                    l2.next = head;
                    l2 = l2.next;
                }
            }
            head = head.next;
        }

        if(l1head==null)
            return l2head;
        if(l2head==null)
            return l1head;
        
        l1.next = l2head;
        l2.next = null;
       return l1head;
        
    }
}