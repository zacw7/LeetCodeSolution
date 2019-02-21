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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList();
        List<Integer> leafs2 = new ArrayList();
        if (root1 != null) searchLeafs(leafs1, root1);
        if (root2 != null) searchLeafs(leafs2, root2);
        if (leafs1.size() != leafs2.size()) return false;
        for (int i = 0; i < leafs1.size(); i++) {
            if (!leafs1.get(i).equals(leafs2.get(i))) return false;
        }
        return true;
    }

    private void searchLeafs(List<Integer> leafs, TreeNode node) {
        if (node.left == null && node.right == null) {
            leafs.add(node.val);
        } else {
            if (node.left != null) searchLeafs(leafs, node.left);
            if (node.right != null) searchLeafs(leafs, node.right);
        }
    }
}