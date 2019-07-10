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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<TreeNode>> offsetMap = new TreeMap();
        Map<TreeNode, Integer> levelMap = new HashMap();
        traverse(root, 0, 0, offsetMap, levelMap);
        List<List<Integer>> res = new ArrayList();
        for (PriorityQueue<TreeNode> queue : offsetMap.values()) {
            List<Integer> list = new ArrayList();
            while (!queue.isEmpty()) {
                list.add(queue.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    private void traverse(TreeNode node, int offset, int level,
                          Map<Integer, PriorityQueue<TreeNode>> offsetMap,
                          Map<TreeNode, Integer> levelMap) {
        if (node == null) {
            return;
        }
        levelMap.put(node, level);
        if (!offsetMap.containsKey(offset)) {
            offsetMap.put(offset, new PriorityQueue<TreeNode>((a, b) -> levelMap.get(a) == levelMap.get(b)
                    ? a.val - b.val
                    : levelMap.get(a) - levelMap.get(b)));
        }
        PriorityQueue<TreeNode> queue = offsetMap.get(offset);
        queue.offer(node);
        traverse(node.left, offset - 1, level + 1, offsetMap, levelMap);
        traverse(node.right, offset + 1, level + 1, offsetMap, levelMap);
    }
}