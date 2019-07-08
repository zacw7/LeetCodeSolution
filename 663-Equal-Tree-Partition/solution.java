/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean checkEqualTree(TreeNode root) {
        Stack<Integer> stack = new Stack();
        int sum = getSum(root, stack);
        if (stack.isEmpty() || sum % 2 != 0) {
            return false;
        }
        int target = stack.pop() / 2;
        while (!stack.isEmpty()) {
            if (target == stack.pop()) {
                return true;
            }
        }
        return false;
    }

    private int getSum(TreeNode node, Stack<Integer> stack) {
        if (node == null) {
            return 0;
        } else {
            int sum = node.val + getSum(node.left, stack) + getSum(node.right, stack);
            stack.push(sum);
            return sum;
        }
    }
}