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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList();
        if (root == null) {
            return ans;
        }
        Set<Integer> toDel = new HashSet();
        for (int d : to_delete) {
            toDel.add(d);
        }
        if (!toDel.contains(root.val)) {
            ans.add(root);
        }
        delHelper(root, toDel, ans);
        return ans;
    }

    private void delHelper(TreeNode node, Set<Integer> toDel, List<TreeNode> ans) {
        if (node == null) {
            return;
        }
        delHelper(node.left, toDel, ans);
        delHelper(node.right, toDel, ans);
        if (toDel.contains(node.val)) {
            if (node.left != null && !toDel.contains(node.left.val)) {
                ans.add(node.left);
            }
            if (node.right != null && !toDel.contains(node.right.val)) {
                ans.add(node.right);
            }
        } else {
            if (node.left != null && toDel.contains(node.left.val)) {
                node.left = null;
            }
            if (node.right != null && toDel.contains(node.right.val)) {
                node.right = null;
            }
        }
    }
}