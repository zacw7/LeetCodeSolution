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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return new TreeNode(v);
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (--d > 1) {
            int c = queue.size();
            while (c-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode lChild = new TreeNode(v), rChild = new TreeNode(v);
            lChild.left = node.left;
            rChild.right = node.right;
            node.left = lChild;
            node.right = rChild;
        }
        return root;
    }
}