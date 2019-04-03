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
    public void recoverTree(TreeNode root) {
        Queue<TreeNode> inorder = new LinkedList();
        Stack<TreeNode> stack = new Stack();
        List<Integer> values = new ArrayList();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();
                values.add(root.val);
                inorder.add(root);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }
        Collections.sort(values);
        for (int i = 0, s = values.size(); i < s && !inorder.isEmpty(); i++) {
            TreeNode node = inorder.poll();
            node.val = values.get(i);
        }
    }
}