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
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack();
        List<Integer> list = new ArrayList();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        for (int i = 1, s = list.size(); i < s; i++) {
            if (list.get(i) <= list.get(i - 1)) return false;
        }
        return true;
    }
}