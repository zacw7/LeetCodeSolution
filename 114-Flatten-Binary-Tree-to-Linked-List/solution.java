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
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode leftChild = cur.left, rightChild = cur.right;
                cur.left = null;
                cur.right = leftChild;
                while (leftChild.right != null) leftChild = leftChild.right;
                leftChild.right = rightChild;
            }
            cur = cur.right;
        }
    }
}