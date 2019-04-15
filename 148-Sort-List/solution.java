/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // divide
        ListNode slow = head, fast = slow.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // conquer
        ListNode node2 = sortList(slow.next);
        slow.next = null;
        ListNode node1 = sortList(head);

        // merge
        ListNode dummy = new ListNode(0), cur = dummy;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                cur.next = node2;
                node2 = node2.next;
            } else if (node2 == null) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                if (node1.val < node2.val) {
                    cur.next = node1;
                    node1 = node1.next;
                } else {
                    cur.next = node2;
                    node2 = node2.next;
                }
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}