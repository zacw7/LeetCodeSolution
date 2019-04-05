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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start >= preorder.length || start > end) return null;
        TreeNode root = new TreeNode(preorder[start++]);
        int i = start;
        while (i < preorder.length && preorder[i] < root.val) i++;
        root.left = helper(preorder, start, i - 1);
        root.right = helper(preorder, i, end);
        return root;
    }
}