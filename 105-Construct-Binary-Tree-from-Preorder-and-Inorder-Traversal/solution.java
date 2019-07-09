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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pre_start, int pre_end,
                               int[] inorder, int in_start, int in_end) {
        if (pre_start > pre_end || in_start > in_end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre_start]);
        if (pre_start < pre_end) {
            int size = 0;
            while (in_start + size < in_end && preorder[pre_start] != inorder[in_start + size]) {
                size++;
            }
            node.left = buildTree(preorder, pre_start + 1, pre_start + size, inorder, in_start, in_start + size - 1);
            node.right = buildTree(preorder, pre_start + 1 + size, pre_end, inorder, in_start + size + 1, in_end);
        }
        return node;
    }
}