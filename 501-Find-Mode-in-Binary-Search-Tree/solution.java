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
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> nodeCount = new HashMap();
        Queue<TreeNode> nodeQueue = new LinkedList();
        if (root != null) nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            nodeCount.put(node.val, nodeCount.getOrDefault(node.val, 0) + 1);
            if (node.left != null) nodeQueue.add(node.left);
            if (node.right != null) nodeQueue.add(node.right);
        }
        List<Integer> modes = new ArrayList();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : nodeCount.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                modes.clear();
                modes.add(entry.getKey());
            } else if (count == max) {
                modes.add(entry.getKey());
            }
        }
        int[] ans = new int[modes.size()];
        for (int i = 0, size = modes.size(); i < size; i++) {
            ans[i] = modes.get(i);
        }
        return ans;
    }
}