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
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val <= V) {
            res[0] = root;
            if (root.right != null) {
                TreeNode[] sub = splitBST(root.right, V);
                res[0].right = sub[0];
                res[1] = sub[1];
            }
        } else {
            res[1] = root;
            if (root.left != null) {
                TreeNode[] sub = splitBST(root.left, V);
                res[1].left = sub[1];
                res[0] = sub[0];
            }
        }
        return res;
    }
}