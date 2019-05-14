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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> nodeMap = new HashMap();
        List<TreeNode> ans = new ArrayList();
        serialize(root, nodeMap, ans);
        return ans;
    }

    private String serialize(TreeNode node, Map<String, Integer> nodeMap, List<TreeNode> ans) {
        if (node == null) {
            return "";
        }
        String serializeNode = String.valueOf(node.val);
        serializeNode = serializeNode + "L" + serialize(node.left, nodeMap, ans);
        serializeNode = serializeNode + "R" + serialize(node.right, nodeMap, ans);
        nodeMap.put(serializeNode, nodeMap.getOrDefault(serializeNode, 0) + 1);
        if (nodeMap.get(serializeNode) == 2) {
            ans.add(node);
        }
        return serializeNode;
    }
}