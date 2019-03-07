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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> nodeQ = new LinkedList();
        Map<Integer, Integer> parentMap = new HashMap();
        if (root != null) nodeQ.add(root);
        while (!nodeQ.isEmpty()) {
            int count = nodeQ.size();
            int sum = x + y;
            while (count-- > 0) {
                TreeNode node = nodeQ.poll();
                if (node.val == x || node.val == y) {
                    sum -= node.val;
                } else {
                    if (node.left != null) {
                        nodeQ.add(node.left);
                        parentMap.put(node.left.val, node.val);
                    }
                    if (node.right != null) {
                        nodeQ.add(node.right);
                        parentMap.put(node.right.val, node.val);
                    }
                }
            }
            if (sum == 0) {
                return parentMap.get(x) != parentMap.get(y);
            } else if (sum == x + y) {
                continue;
            } else {
                return false;
            }
        }
        return false;
    }
}