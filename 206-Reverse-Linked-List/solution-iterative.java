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
        ListNode prev = null, cur = head, next = head.next;
        head.next = null;
        while (next != null) {
            prev = cur;
            cur = next;
            next = next.next;
            cur.next = prev;
        }
        return cur;
    }
}