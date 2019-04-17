/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy;
        while (m > 1) {
            tail = tail.next;
            m--;
            n--;
        }

        ListNode subTail = tail.next, subHead = subTail.next;
        ListNode prev = subTail, next = subHead.next;
        while (n > 1) {
            subHead.next = prev;
            prev = subHead;
            subHead = next;
            if (next != null) {
                next = next.next;
            }
            n--;
        }

        tail.next = prev;
        subTail.next = subHead;

        return dummy.next;
    }
}