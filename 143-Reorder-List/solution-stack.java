/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // stack
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        node = head;
        while (node != null) {
            ListNode tail = stack.pop();
            if (tail == node || tail == node.next) {
                tail.next = null;
                break;
            }
            tail.next = node.next;
            node.next = tail;
            node = tail.next;
        }
    }
}