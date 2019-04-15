/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        ListNode meetNode = slow, node = head;
        while (meetNode != node) {
            meetNode = meetNode.next;
            node = node.next;
        }

        return node;
    }
}