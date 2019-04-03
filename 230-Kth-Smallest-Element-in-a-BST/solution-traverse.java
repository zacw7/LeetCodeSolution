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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                if (--k == 0) return root.val;
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        return 0;
    }
}