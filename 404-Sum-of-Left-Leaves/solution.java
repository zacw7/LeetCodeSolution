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
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> nodeQ = new LinkedList();
        if (root != null) nodeQ.add(root);
        while(!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) sum += node.left.val;
                else nodeQ.add(node.left);
            }
            if (node.right != null) {
                if (node.right.left != null || node.right.right != null) nodeQ.add(node.right);
            }
        }
        return sum;
    }
}