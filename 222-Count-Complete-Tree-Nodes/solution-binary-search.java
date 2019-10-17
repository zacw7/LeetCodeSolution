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
    public int countNodes(TreeNode root) {
        int depth = 0;
        TreeNode node = root;
        while (node != null) {
            depth++;
            node = node.left;
        }
        if (depth <= 1) {
            return depth;
        }
        int lo = 0, hi = (int) Math.pow(2, depth - 1) - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(mid + "    " + lo + "/" + hi);
            if (isExist(root, depth, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int) Math.pow(2, depth - 1) - 1 + lo;
    }

    private boolean isExist(TreeNode root, int depth, int index) {
        TreeNode node = root;
        int cur = (int) Math.pow(2, depth - 2);
        while (cur > 0) {
            if ((index / cur) % 2 == 0) {
                node = node.left;
            } else  {
                node = node.right;
            }
            cur /= 2;
        }
        return node != null;
    }
}