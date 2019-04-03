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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumCount = new HashMap();
        if (root != null) helper(root, sumCount);
        List<Integer> list = new ArrayList();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : sumCount.entrySet()) {
            if (entry.getValue() > max) {
                list.clear();
                max = entry.getValue();
            }
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }

    private int helper(TreeNode node, Map<Integer, Integer> sumCount) {
        int cur = node.val;
        if (node.left != null) cur += helper(node.left, sumCount);
        if (node.right != null) cur += helper(node.right, sumCount);
        sumCount.put(cur, sumCount.getOrDefault(cur, 0) + 1);
        return cur;
    }
}