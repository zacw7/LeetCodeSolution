/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private ListNode head;
    private Random rand;
    private int len;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
        this.len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int n = rand.nextInt(len);
        ListNode node = head;
        while (n-- > 0) {
            node = node.next;
        }
        return node.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */