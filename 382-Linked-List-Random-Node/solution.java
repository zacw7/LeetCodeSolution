/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private ListNode[] nodes;
    private Random rand;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        List<ListNode> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        this.nodes = list.toArray(new ListNode[list.size()]);
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        return nodes[rand.nextInt(nodes.length)].val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */