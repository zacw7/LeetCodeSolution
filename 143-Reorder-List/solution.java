/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // two points
    // Time: O(n)
    // Space: O(1)
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode l1 = head, l2 = slow.next;
        slow.next = null;
        // reverse l2
        ListNode prev = null, cur = l2;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        l2 = prev;
        //  weave
        while (l1 != null) {
            ListNode n1 = l1.next;
            l1.next = l2;
            l1 = n1;
            if (l2 != null) {
                ListNode n2 = l2.next;
                l2.next = n1;
                l2 = n2;
            }
        }
    }
}