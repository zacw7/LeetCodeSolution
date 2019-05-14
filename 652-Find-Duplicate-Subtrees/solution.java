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
        Map<String, List<TreeNode>> nodeMap = new HashMap();
        serialize(root, nodeMap);
        List<TreeNode> duplicates = new ArrayList();
        for (List<TreeNode> nodeList : nodeMap.values()) {
            if (nodeList.size() > 1) {
                duplicates.add(nodeList.get(0));
            }
        }
        return duplicates;
    }

    private String serialize(TreeNode node, Map<String, List<TreeNode>> nodeMap) {
        if (node == null) {
            return "";
        }
        String serializeNode = String.valueOf(node.val);
        serializeNode = serializeNode + "L" + serialize(node.left, nodeMap);
        serializeNode = serializeNode + "R" + serialize(node.right, nodeMap);
        List<TreeNode> nodeList = nodeMap.getOrDefault(serializeNode, new ArrayList());
        nodeList.add(node);
        nodeMap.put(serializeNode, nodeList);
        return serializeNode;
    }
}