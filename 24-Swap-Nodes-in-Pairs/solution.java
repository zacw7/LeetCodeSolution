/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode n1 = prev.next;
        while (n1 != null && n1.next != null) {
            ListNode n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            prev.next = n2;
            prev = n1;
            n1 = prev.next;
        }
        return dummy.next;
    }
}