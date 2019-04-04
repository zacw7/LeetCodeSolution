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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        boolean flag = false; // if true, no more children
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (flag) return false;
                queue.add(node.left);
            } else flag = true;
            if (node.right != null) {
                if (flag) return false;
                queue.add(node.right);
            } else flag = true;
        }
        return true;
    }
}