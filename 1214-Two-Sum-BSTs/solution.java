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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set = new HashSet();
        traverse(root1, set);
        return search(root2, set, target);
    }

    private void traverse(TreeNode node, Set<Integer> set) {
        if (node == null) {
            return;
        }
        set.add(node.val);
        traverse(node.left, set);
        traverse(node.right, set);
    }

    private boolean search(TreeNode node, Set<Integer> set, int target) {
        if (node == null) {
            return false;
        }
        return set.contains(target - node.val) || search(node.left, set, target) || search(node.right, set, target);
    }
}