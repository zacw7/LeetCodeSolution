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
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, int[]> levelBoundMap = new HashMap();
        traverseHelper(root, 0, 1, levelBoundMap);
        int maxWidth = 0;
        for (int[] bound : levelBoundMap.values()) {
            maxWidth = Math.max(maxWidth, bound[1] - bound[0] + 1);
        }
        return maxWidth;
    }

    private void traverseHelper(TreeNode node, int order, int level, HashMap<Integer, int[]> levelBoundMap) {
        if (node == null) {
            return;
        }
        int[] bound = levelBoundMap.getOrDefault(level, new int[]{order, order});
        bound[0] = Math.min(order, bound[0]);
        bound[1] = Math.max(order, bound[1]);
        levelBoundMap.put(level, bound);
        traverseHelper(node.left, order * 2, level + 1, levelBoundMap);
        traverseHelper(node.right, order * 2 + 1, level + 1, levelBoundMap);
    }
}