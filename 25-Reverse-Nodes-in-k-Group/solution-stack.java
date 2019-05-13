/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // Stack
    // T: O(n)
    // T: O(k)
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Stack<ListNode> stack = new Stack();
        ListNode prev = dummy, next = prev.next;
        while (next != null) {
            while (next != null && stack.size() < k) {
                stack.push(next);
                next = next.next;
            }
            if (stack.size() == k) {
                // reverse
                while (!stack.isEmpty()) {
                    ListNode node = stack.pop();
                    prev.next = node;
                    prev = node;
                }
                prev.next = next;
            }
        }
        return dummy.next;
    }
}