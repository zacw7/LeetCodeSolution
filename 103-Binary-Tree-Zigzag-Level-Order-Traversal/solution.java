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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            boolean isReverse = ans.size() % 2 == 1;
            int count = queue.size();
            List<Integer> level = new ArrayList();
            Stack<Integer> stack = new Stack();
            while (count-- > 0) {
                TreeNode node = queue.poll();
                if (!isReverse) level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (isReverse) stack.push(node.val);
            }
            while (!stack.isEmpty()) level.add(stack.pop());
            ans.add(level);
        }
        return ans;
    }
}