/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int d = carry;
            if (l1 != null) {
                d += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                d += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(d % 10);
            node = node.next;
            carry = d / 10;
        }
        if (dummy.next == null) {
            return dummy;
        } else {
            return dummy.next;
        }
    }
}