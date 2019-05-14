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
        ListNode dummy = new ListNode(0);
        Stack<ListNode> stack1 = new Stack();
        Stack<ListNode> stack2 = new Stack();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int n1 = 0, n2 = 0;
            if (!stack1.isEmpty()) {
                n1 = stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                n2 = stack2.pop().val;
            }
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }
}