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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<TreeNode, Integer> offsetMap = new HashMap();
        traverseHelper(root, 0, offsetMap);

        Map<Integer, List<Integer>> nodesMap = new TreeMap();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                List<Integer> list = nodesMap.getOrDefault(offsetMap.get(node), new ArrayList());
                nodesMap.put(offsetMap.get(node), list);
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return new ArrayList(nodesMap.values());
    }

    private void traverseHelper(TreeNode node, int offset, Map<TreeNode, Integer> offsetMap) {
        if (node == null) {
            return;
        }
        offsetMap.put(node, offset);
        traverseHelper(node.left, offset - 1, offsetMap);
        traverseHelper(node.right, offset + 1, offsetMap );
    }
}