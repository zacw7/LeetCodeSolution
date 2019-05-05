/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        Stack<ListNode> stack = new Stack();
        stack.push(dummy);
        while (stack.peek().next != null) {
            stack.push(stack.peek().next);
        }

        ListNode tail = stack.pop();
        if (tail.val == 9) {
            tail.val = 0;
            while (!stack.isEmpty()) {
                ListNode node = stack.pop();
                node.val += 1;
                if (node.val < 10) {
                    break;
                } else {
                    node.val = 0;
                }
            }
        } else {
            tail.val += 1;
        }
        return (dummy.val == 0) ? dummy.next : dummy;
    }
}