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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        if (root == null) return ans;
        TreeNode sentinel = new TreeNode(0);
        sentinel.right = root;
        while (true) {
            if (sentinel.right == null) break;
            List<Integer> list = new ArrayList();
            removeLeaves(sentinel, list);
            ans.add(list);
        }
        return ans;
    }

    private void removeLeaves(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                list.add(node.left.val);
                node.left = null;
            } else removeLeaves(node.left, list);
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                list.add(node.right.val);
                node.right = null;
            } else removeLeaves(node.right, list);
        }
    }
}