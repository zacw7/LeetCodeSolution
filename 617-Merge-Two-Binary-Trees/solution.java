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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode mergedNode = new TreeNode(0);
        if (t1 != null) {
            mergedNode.val += t1.val;
        }
        if (t2 != null) {
            mergedNode.val += t2.val;
        }
        mergedNode.left = mergeTrees((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        mergedNode.right = mergeTrees((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);
        return mergedNode;
    }
}