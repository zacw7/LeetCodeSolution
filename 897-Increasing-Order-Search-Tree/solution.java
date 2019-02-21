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
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = root;
        TreeNode prevNode = new TreeNode(-1);
        root = prevNode;
        prevNode.right = node;

        while (node != null) {
            if (node.left != null) {
                prevNode.right = node.left;
                TreeNode rightLeaf = node.left;
                while (rightLeaf.right != null) {
                    rightLeaf = rightLeaf.right;
                }
                rightLeaf.right = node;
                node.left = null;
                node = prevNode.right;
            } else {
                prevNode = node;
                node = node.right;
            }
        }
        return root.right;
    }
}