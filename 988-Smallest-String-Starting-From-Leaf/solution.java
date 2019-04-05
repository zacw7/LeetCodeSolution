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

    String ans;

    public String smallestFromLeaf(TreeNode root) {
        if (root != null) dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        sb.append((char) ('a' + node.val));
        if (node.left == null && node.right == null) {
            String cur = sb.reverse().toString();
            if (ans == null || cur.compareTo(ans) < 0) ans = cur;
            sb.reverse();
        } else {
            if (node.left != null) dfs(node.left, sb);
            if (node.right != null) dfs(node.right, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
}