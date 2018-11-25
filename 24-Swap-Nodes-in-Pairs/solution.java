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

        ListNode pre = null, cur = head;
        while (cur != null && cur.next !=null) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = cur;
            if (pre == null) {
                head = next;
            } else {
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}