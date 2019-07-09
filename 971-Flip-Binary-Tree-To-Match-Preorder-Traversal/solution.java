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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList();
        if (voyage.length != flipMatchVoyage(root, voyage, 0, res)) {
            res.clear();
            res.add(-1);
        }
        return res;
    }

    private int flipMatchVoyage(TreeNode node, int[] voyage, int i, List<Integer> res) {
        if (i >= voyage.length || voyage[i] != node.val) {
            res.clear();
            res.add(-1);
        } else {
            i++;
            if (node.left != null && node.right != null) {
                if (node.left.val != voyage[i]) {
                    res.add(node.val);
                    swapChild(node);
                }
                i = flipMatchVoyage(node.left, voyage, i, res);
                i = flipMatchVoyage(node.right, voyage, i, res);
            } else if (node.left != null) {
                i = flipMatchVoyage(node.left, voyage, i, res);
            } else if (node.right != null) {
                i = flipMatchVoyage(node.right, voyage, i, res);
            }
        }
        return i;
    }

    private void swapChild(TreeNode node) {
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}