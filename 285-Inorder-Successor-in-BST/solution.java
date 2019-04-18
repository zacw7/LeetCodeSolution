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
    // inorder traverse
    // T: O(n) - every node will be visited twice
    // S: O(n) - stack used
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack();
        boolean flag = false;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (flag) {
                    return root;
                } else if (root == p) {
                    flag = true;
                }
                root = root.right;
            }
        }

        return null;
    }
}