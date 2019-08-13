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
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int in_start, int in_end, int[] postorder, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_end]);
        if (post_start < post_end) {
            int mid = in_end;
            while (inorder[mid] != root.val) {
                mid--;
            }
            root.left = buildTree(inorder, in_start, mid - 1, postorder, post_start, post_start + mid - 1 - in_start);
            root.right = buildTree(inorder, mid + 1, in_end, postorder, post_start + mid - in_start, post_end - 1);
        }
        return root;
    }
}