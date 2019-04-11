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
        if (head == null || head.next == null) return head;
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode head1 = sentinel, head2 = sentinel.next;
        ListNode p1 = head1, p2 = head2;
        // seperate
        while (p1 != null || p2 != null) {
            if (p2 != null) p1.next = p2.next;
            else p1.next = null;
            p1 = p1.next;
            if (p2 != null) {
                if (p1 != null) p2.next = p1.next;
                else p2.next = null;
                p2 = p2.next;
            }
        }
        // interwave
        p1 = head1.next;
        p2 = head2;
        interwave(p1, p2);
        return sentinel.next;
    }

    private ListNode interwave(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        p2.next = interwave(p1.next, p2.next);
        p1.next = p2;
        return p1;
    }
}