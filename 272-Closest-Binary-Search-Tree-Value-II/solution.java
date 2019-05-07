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
    // Time: O(n)
    // Space: O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> vals = new ArrayList();
        if (root == null || k == 0) {
            return vals;
        }
        traverseHelper(root, vals);
        int left = 0, right = vals.size();
        while (right - left > k) {
            if (Math.abs((double) vals.get(left) - target)
                    > Math.abs((double) vals.get(right - 1) - target)) {
                left++;
            } else {
                right--;
            }
        }
        return vals.subList(left, right);
    }

    private void traverseHelper(TreeNode node, List<Integer> vals) {
        if (node == null) {
            return;
        }
        traverseHelper(node.left, vals);
        vals.add(node.val);
        traverseHelper(node.right, vals);
    }
}