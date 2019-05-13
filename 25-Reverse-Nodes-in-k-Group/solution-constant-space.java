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
    // T: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, next = dummy.next;
        while (next != null) {
            int t = k;
            while (next != null && t > 0) {
                next = next.next;
                t--;
            }
            if (t == 0) {
                ListNode cur = prev.next;
                while (cur.next != next) {
                    ListNode tHead = cur.next, tNext = cur.next.next;
                    tHead.next = prev.next;
                    prev.next = tHead;
                    cur.next = tNext;
                }
                prev = cur;
            }
        }

        return dummy.next;
    }
}