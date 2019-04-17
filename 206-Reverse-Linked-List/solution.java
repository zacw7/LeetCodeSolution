/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // T: O(n)
    // S: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;
        head = head.next;
        ListNode next = head.next;

        prev.next = null;
        head.next = prev;

        while (next != null) {
            prev = head;
            head = next;
            next = next.next;
            head.next = prev;
        }

        return head;
    }
}