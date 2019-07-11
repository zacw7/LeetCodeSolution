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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        int H = getHeight(root);
        int W = (int)Math.pow(2, H) - 1;
        // init the res
        for (int h = 0; h < H; h++) {
            List<String> row = new ArrayList();
            for (int w = 0; w < W; w++) {
                row.add("");
            }
            res.add(row);
        }
        // fill the res
        traverseHelper(root, 0, W / 2, (W + 1) / 2, res);
        return res;
    }

    private void traverseHelper(TreeNode node, int x, int y, int offset, List<List<String>> res) {
        if (node == null) {
            return;
        }
        offset /= 2;
        res.get(x).set(y, String.valueOf(node.val));
        traverseHelper(node.left, x + 1, y - offset, offset, res);
        traverseHelper(node.right, x + 1, y + offset, offset, res);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }
    }
}