/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> seen = new HashMap();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = head;
        int sum = 0;
        seen.put(sum, dummy);
        while (node != null) {
            sum += node.val;
            if (seen.containsKey(sum)) {
                ListNode prev = seen.get(sum);
                prev.next = node.next;
                node = prev;
            }
            seen.put(sum, node);
            node = node.next;
        }
        return dummy.next;
    }
}