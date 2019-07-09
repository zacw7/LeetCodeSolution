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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Map<TreeNode, TreeNode> parents = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        Set<TreeNode> nodes = new HashSet();
        queue.offer(root);
        while (!queue.isEmpty()) {
            nodes = new HashSet(queue);
            int s = queue.size();
            while (s-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parents.put(node.left, node);
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    queue.offer(node.right);
                }
            }
        }
        while (nodes.size() > 1) {
            Set<TreeNode> tmp = new HashSet();
            for (TreeNode node : nodes) {
                tmp.add(parents.get(node));
            }
            nodes = tmp;
        }
        for (TreeNode node : nodes) {
            return node;
        }
        return null;
    }
}