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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList();
        Queue<TreeNode> nodeQ = new LinkedList();
        nodeQ.add(root);
        double sum = 0;
        int count = 1, currentLevel = 1;
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            if (node.left != null) nodeQ.add(node.left);
            if (node.right != null) nodeQ.add(node.right);
            sum += node.val;
            count--;
            if (count == 0) {
                ans.add(sum / currentLevel);
                sum = 0;
                currentLevel = nodeQ.size();
                count = currentLevel;
            }
        }
        return ans;
    }
}