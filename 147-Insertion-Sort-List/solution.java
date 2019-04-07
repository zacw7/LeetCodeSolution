/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        Queue<ListNode> queue = new LinkedList();
        while (node != null) {
            queue.add(node);
            ListNode tmp = node;
            node = node.next;
            tmp.next = null;
        }
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        while (!queue.isEmpty()) {
            ListNode select = queue.poll();
            ListNode prev = sentinel, cur = prev.next;
            while (cur != null && select.val > cur.val) {
                prev = cur;
                cur = cur.next;
            }
            select.next = cur;
            prev.next = select;
        }
        return sentinel.next;
    }
}