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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd,
                            int[] postorder, int postStart, int postEnd) {
        if (inStart == inEnd) return new TreeNode(inorder[inStart]);
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIn = 0;
        while (inorder[rootIn] != postorder[postEnd]) rootIn++;
        int leftLen = rootIn - inStart - 1, rightLen = inEnd - rootIn - 1;
        if (leftLen >= 0)
            root.left = helper(inorder, inStart, rootIn - 1, postorder, postStart, postStart + leftLen);
        if (rightLen >= 0)
            root.right = helper(inorder, rootIn + 1, inEnd, postorder, postEnd - 1 - rightLen, postEnd - 1);
        return root;
    }
}