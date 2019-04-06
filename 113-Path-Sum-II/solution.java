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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList();
        if (root != null) dfs(root, new ArrayList(), sum, ans);
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> list, int sum, List<List<Integer>> ans) {
        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == node.val) ans.add(list);
        } else if (node.left != null) {
            if (node.right != null) dfs(node.right, new ArrayList(list), sum - node.val, ans);
            dfs(node.left, list, sum - node.val, ans);
        } else if (node.right != null) dfs(node.right, list, sum - node.val, ans);
    }
}