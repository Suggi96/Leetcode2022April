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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int len = 0;
        while(cur!=null) {
            cur = cur.next;
            len++;
        }
        int i = 1;
        ListNode first = head, second = head;
        while(i!=k) {
            first = first.next;
            i++;
        }
        i = 1;
        while(i!=(len-k+1)){
            second = second.next;
            i++;
        }
        System.out.print(first.val + " "+ second.val);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return head;
    }
}