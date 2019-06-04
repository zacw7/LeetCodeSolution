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
        List<Integer> valList = new ArrayList();
        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }
        int[] ans = new int[valList.size()];
        Stack<Integer> stack = new Stack();
        for (int i = ans.length - 1; i >= 0; i--) {
            int val = valList.get(i);
            while (!stack.isEmpty() && stack.peek() <= val) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(val);
        }
        return ans;
    }
}