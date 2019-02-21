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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> leafs = new LinkedList();
        Stack<TreeNode> nodeStack = new Stack();
        while (!nodeStack.isEmpty() || root1 != null) {
            if (root1 == null) {
                root1 = nodeStack.pop().right;
            } else {
                nodeStack.push(root1);
                if (root1.left == null && root1.right == null) {
                    leafs.offer(root1.val);
                    root1 = null;
                } else {
                    root1 = root1.left;
                }
            }
        }
        while (!nodeStack.isEmpty() || root2 != null) {
            if (root2 == null) {
                root2 = nodeStack.pop().right;
            } else {
                nodeStack.push(root2);
                if (root2.left == null && root2.right == null) {
                    if (!leafs.poll().equals(root2.val)) return false;
                    root2 = null;
                } else {
                    root2 = root2.left;
                }
            }
        }
        return true;
    }
}