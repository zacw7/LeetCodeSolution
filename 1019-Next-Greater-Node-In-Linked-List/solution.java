/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> numList = new ArrayList();
        ListNode node = head;
        while (node != null) {
            numList.add(node.val);
            node = node.next;
        }
        int[] ans = new int[numList.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = numList.get(i);
        for (int i = 0; i < ans.length; i++) {
            int cur = ans[i];
            ans[i] = 0;
            for (int j = i + 1; j < ans.length; j++) {
                if (ans[j] > cur) {
                    ans[i] = ans[j];
                    break;
                }
            }
        }
        return ans;
    }
}