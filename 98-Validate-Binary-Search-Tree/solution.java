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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        preOrderTraverse(list, root);
        for (int i = 1, s = list.size(); i < s; i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }

    private void preOrderTraverse(List<Integer> list, TreeNode node) {
        if (node == null) return;
        preOrderTraverse(list, node.left);
        list.add(node.val);
        preOrderTraverse(list, node.right);
    }
}