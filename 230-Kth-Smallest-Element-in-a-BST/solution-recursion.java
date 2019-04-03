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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList();
        helper(root, inorder);
        return inorder.get(k - 1);
    }

    private void helper(TreeNode node, List<Integer> inorder) {
        if (node == null) return;
        helper(node.left, inorder);
        inorder.add(node.val);
        helper(node.right, inorder);
    }
}