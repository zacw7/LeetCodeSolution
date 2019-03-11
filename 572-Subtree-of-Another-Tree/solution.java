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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> nodeQ = new LinkedList();
        nodeQ.add(s);
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            if (node.val == t.val && isSameNode(node, t)) {
                return true;
            }
            if (node.left != null) nodeQ.add(node.left);
            if (node.right != null) nodeQ.add(node.right);
        }
        return false;
    }

    private boolean isSameNode(TreeNode source, TreeNode target) {
        if (source == null && target == null) return true;
        if (source != null && target != null && source.val == target.val) {
            return isSameNode(source.left, target.left) && isSameNode(source.right, target.right);
        } else {
            return false;
        }
    }
}