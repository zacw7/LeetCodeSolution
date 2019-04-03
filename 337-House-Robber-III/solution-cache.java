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
    public int rob(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap();
        return helper(root, map);
    }

    private int helper(TreeNode node, Map<TreeNode, Integer> map) {
        if (!map.containsKey(node)) {
            int nextLevel = 0, next2Level = 0;
            if (node.left != null) {
                nextLevel += helper(node.left, map);
                if (node.left.left != null) next2Level += helper(node.left.left, map);
                if (node.left.right != null) next2Level += helper(node.left.right, map);
            }
            if (node.right != null) {
                nextLevel += helper(node.right, map);
                if (node.right.left != null) next2Level += helper(node.right.left, map);
                if (node.right.right != null) next2Level += helper(node.right.right, map);
            }
            map.put(node, Math.max(nextLevel, next2Level + node.val));
        }
        return map.get(node);
    }
}