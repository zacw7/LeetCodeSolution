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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ans.add(root.val);
                if (root.left != null) stack.push(root.left);
                root = root.right;
            } else {
                root = stack.pop();
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}