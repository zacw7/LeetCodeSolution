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
    // Stack
    // TC: O(N)
    // SC: O(N)
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Stack<TreeNode> nodeStack = new Stack();
        TreeNode node = new TreeNode(0);
        int sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                node.val *= 10;
                node.val += sign * (c - '0');
            } else if (c == '(') {
                nodeStack.push(node);
                node = new TreeNode(0);
                sign = 1;
            } else if (c == ')') {
                TreeNode parent = nodeStack.pop();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                node = parent;
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            }
        }
        return node;
    }
}