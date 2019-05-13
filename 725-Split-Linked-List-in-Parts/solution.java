/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int count = 0;
        for (ListNode node = root; node != null; node = node.next) {
            count++;
        }
        int each = count / k;
        int rest = count % k;
        ListNode node = root;
        for (int i = 0; i < k; i++) {
            int t = (i < rest) ? 1 : 0;
            t += each;
            if (t == 0 || node == null) {
                parts[i] = null;
                continue;
            } else {
                parts[i] = node;
                while (t > 1) {
                    node = node.next;
                    t--;
                }
                if (node != null) {
                    ListNode next = node.next;
                    node.next = null;
                    node = next;
                }
            }
        }
        return parts;
    }
}