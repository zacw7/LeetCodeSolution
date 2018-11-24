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
        Stack<Integer> stackOfList1 = new Stack();
        Stack<Integer> stackOfList2 = new Stack();

        while (l1 != null) {
            stackOfList1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stackOfList2.push(l2.val);
            l2 = l2.next;
        }

        int carryBit = 0;
        ListNode node = null, head = null;
        while (!stackOfList1.isEmpty() && !stackOfList2.isEmpty()) {
            int addend1 = stackOfList1.pop(), addend2 = stackOfList2.pop();
            head = new ListNode((addend1 + addend2 + carryBit) % 10);
            if (node != null) head.next = node;
            node = head;
            carryBit = (addend1 + addend2 + carryBit) / 10;
        }
        while (!stackOfList1.isEmpty()) {
            int addend = stackOfList1.pop();
            head = new ListNode((addend + carryBit) % 10);
            if (node != null) head.next = node;
            node = head;
            carryBit = (addend + carryBit) / 10;
        }
        while (!stackOfList2.isEmpty()) {
            int addend = stackOfList2.pop();
            head = new ListNode((addend + carryBit) % 10);
            if (node != null) head.next = node;
            node = head;
            carryBit = (addend + carryBit) / 10;
        }
        if (carryBit > 0) {
            head = new ListNode(1);
            head.next = node;
        }
        return head;
    }
}