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
    public int sumEvenGrandparent(TreeNode root) {
        return tvs(root, null, null);
    }

    private int tvs(TreeNode node, TreeNode parent, TreeNode ansc) {
        if (node == null) {
            return 0;
        }
        int cur = 0;
        if (ansc != null && ansc.val % 2 == 0) {
            cur += node.val;
        }
        return cur + tvs(node.left, node, parent) + tvs(node.right, node, parent);
    }
}