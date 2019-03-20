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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> nodeStack = new Stack();
        List<Integer> nodeList = new ArrayList();
        while (!nodeStack.isEmpty() || root != null) {
            if (root == null) {
                root = nodeStack.pop();
                nodeList.add(root.val);
                root = root.right;
            } else {
                nodeStack.push(root);
                root = root.left;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1, prev = nodeList.get(0), size = nodeList.size(); i < size; i++) {
            int cur = nodeList.get(i);
            int diff = Math.abs(cur - prev);
            if (diff < min) min = diff;
            prev = cur;
        }
        return min;
    }
}