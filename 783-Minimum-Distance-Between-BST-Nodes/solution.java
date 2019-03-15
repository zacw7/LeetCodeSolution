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
    public int minDiffInBST(TreeNode root) {
        Queue<TreeNode> nodeQ = new LinkedList();
        if (root != null) nodeQ.add(root);
        List<Integer> valueList = new ArrayList();
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            valueList.add(node.val);
            if (node.left != null) nodeQ.add(node.left);
            if (node.right != null) nodeQ.add(node.right);
        }
        Collections.sort(valueList);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < valueList.size(); i++) {
            int diff = valueList.get(i) - valueList.get(i - 1);
            if (diff < min) min = diff;
        }
        return min;
    }
}