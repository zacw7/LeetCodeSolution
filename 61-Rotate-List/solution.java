/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int N = 0;
        for (ListNode node = head; node != null; node = node.next) {
            N++;
        }
        k %= N;
        ListNode fast = head, slow = head;
        while (k-- > 0) {
            fast = fast.next;
            if (fast == null) {
                fast = head;
            }
        }
        if (fast == slow) {
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}