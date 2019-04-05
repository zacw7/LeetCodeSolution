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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 1) {
                TreeNode node = queue.poll();
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
                count--;
            }
            TreeNode last = queue.poll();
            if (last.right != null) queue.add(last.right);
            if (last.left != null) queue.add(last.left);
            if (queue.size() == 0) return last.val;
        }
        return 0;
    }
}