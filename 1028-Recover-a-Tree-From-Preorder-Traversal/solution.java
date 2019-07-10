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
    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int depth = 0;
        Stack<TreeNode> nodeStack = new Stack();
        int i = 0;
        char[] chs = S.toCharArray();
        while (i < chs.length) {
            if (Character.isDigit(chs[i])) {
                int val = 0;
                while (i < chs.length && Character.isDigit(chs[i])) {
                    val *= 10;
                    val += chs[i] - '0';
                    i++;
                }
                TreeNode node = new TreeNode(val);
                if (!nodeStack.isEmpty()) {
                    while (nodeStack.size() > depth) {
                        nodeStack.pop();
                    }
                    TreeNode parent = nodeStack.peek();
                    if (parent.left == null) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
                nodeStack.push(node);
            } else {
                depth = 0;
                while (i < chs.length && chs[i] == '-') {
                    depth++;
                    i++;
                }
            }
        }
        while (nodeStack.size() > 1) {
            nodeStack.pop();
        }
        return nodeStack.pop();
    }
}