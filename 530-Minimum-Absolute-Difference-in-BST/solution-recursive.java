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

    List<Integer> nodeList = new ArrayList();

    public int getMinimumDifference(TreeNode root) {
        if (root != null) inorderTraverse(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1, prev = nodeList.get(0), size = nodeList.size(); i < size; i++) {
            int cur = nodeList.get(i);
            int diff = Math.abs(prev - cur);
            if (diff < min) min = diff;
            prev = cur;
        }
        return min;
    }

    private void inorderTraverse(TreeNode node) {
        if (node.left != null) inorderTraverse(node.left);
        nodeList.add(node.val);
        if (node.right != null) inorderTraverse(node.right);
    }
}