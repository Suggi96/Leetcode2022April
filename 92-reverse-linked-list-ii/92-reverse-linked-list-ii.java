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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next==null || left==right)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode leftPrev = dummy;
        ListNode cur = head;
        for(int i=1;i<=left-1;i++) {
         //   System.out.print("yes");
            leftPrev = cur;
            cur = cur.next;
        }
  //      System.out.println("");
        ListNode prev = null;
        for(int i=1;i<=right-left+1;i++) {
         //   System.out.print("yes");
            ListNode forw = cur.next;
            cur.next = prev;
            prev = cur;
            cur = forw;
        }
   //     System.out.print();
        leftPrev.next.next = cur;
        leftPrev.next = prev;
        return dummy.next;
    }
}