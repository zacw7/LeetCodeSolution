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
    public int maxLevelSum(TreeNode root) {
        int maxLevel = 0, curLevel = 0, maxSum = 0;
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            curLevel++;
            int sum = 0, size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxLevel = curLevel;
            }
        }
        return maxLevel;
    }
}