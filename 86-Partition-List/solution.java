/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel1 = new ListNode(0);
        ListNode sentinel2 = new ListNode(0);

        ListNode n = head, n1 = sentinel1, n2 = sentinel2;
        while (n != null) {
            if (n.val < x) {
                n1.next = n;
                n1 = n;
            } else {
                n2.next = n;
                n2 = n;
            }
            n = n.next;
        }
        n2.next = null;
        n1.next = sentinel2.next;
        return sentinel1.next;
    }
}