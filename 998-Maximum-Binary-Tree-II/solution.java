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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null || root.val < val) {
            node.left = root;
            root = node;
        } else {
            TreeNode prev = root, cur = prev.right;
            while (cur != null && cur.val > val) {
                prev = cur;
                cur = cur.right;
            }
            node.left = cur;
            prev.right = node;
        }
        return root;
    }
}