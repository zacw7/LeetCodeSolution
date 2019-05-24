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
    Map<TreeNode, TreeNode> parents = new HashMap();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList();
        if (root == null || target == null) {
            return ans;
        }
        find(root, target);
        look(target, K, new HashSet(), ans);
        return ans;
    }

    private void find(TreeNode node, TreeNode target) {
        if (node == target) {
            return;
        }
        if (node.left != null) {
            parents.put(node.left, node);
            find(node.left, target);
        }
        if (node.right != null) {
            parents.put(node.right, node);
            find(node.right, target);
        }
    }

    private void look(TreeNode node, int dist, Set<Integer> visited, List<Integer> ans) {
        if (node == null || visited.contains(node.val)) {
            return;
        }
        if (dist == 0) {
            ans.add(node.val);
            return;
        }
        visited.add(node.val);
        look(node.left, dist - 1, visited, ans);
        look(node.right, dist - 1, visited, ans);
        look(parents.get(node), dist - 1, visited, ans);
    }
}