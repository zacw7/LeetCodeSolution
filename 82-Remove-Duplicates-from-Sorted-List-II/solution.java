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
    // S: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            if (prev.next.val == prev.next.next.val) {
                ListNode curr = prev.next.next.next;
                while (curr != null && curr.val == prev.next.val) {
                    curr = curr.next;
                }
                prev.next = curr;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}