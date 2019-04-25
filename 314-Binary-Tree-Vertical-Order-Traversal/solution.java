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
    private Map<TreeNode, Integer> levelMap = new HashMap();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<TreeNode>> offsetMap = new TreeMap();
        traverseHelper(root, 0, offsetMap, 0);

        List<List<Integer>> ans = new ArrayList();
        for (List<TreeNode> list : offsetMap.values()) {
            List<Integer> cur = new ArrayList();
            list.sort((o1, o2) -> levelMap.get(o1) - levelMap.get(o2));
            for (TreeNode node : list) {
                cur.add(node.val);
            }
            ans.add(cur);
        }
        return ans;
    }

    private void traverseHelper(TreeNode node, int offset, Map<Integer, List<TreeNode>> offsetMap, int level) {
        if (node == null) {
            return;
        }

        List<TreeNode> list = offsetMap.getOrDefault(offset, new ArrayList());
        list.add(node);
        offsetMap.put(offset, list);
        levelMap.put(node, level);

        traverseHelper(node.left, offset - 1, offsetMap, level + 1);
        traverseHelper(node.right, offset + 1, offsetMap, level + 1);
    }
}