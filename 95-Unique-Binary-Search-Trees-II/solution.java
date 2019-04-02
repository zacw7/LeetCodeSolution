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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList();
        return dp(1, n);
    }

    public List<TreeNode> dp(int start, int end) {
        List<TreeNode> res = new ArrayList();
        if (start > end) {
            res.add(null);
        } else if (start == end) {
            res.add(new TreeNode(start));
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftSubTrees = dp(start, i - 1);
                List<TreeNode> rightSubTrees = dp(i + 1, end);
                for (TreeNode leftChild : leftSubTrees) {
                    for (TreeNode rightChild : rightSubTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftChild;
                        root.right = rightChild;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}