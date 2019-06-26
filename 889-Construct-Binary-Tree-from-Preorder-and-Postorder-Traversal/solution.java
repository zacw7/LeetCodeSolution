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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if (pre == null || post == null || pre.length != post.length || pre.length == 0) {
            return null;
        }
        return constructHelper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode constructHelper(int[] pre, int i_start, int i_end,
                                     int[] post, int j_start, int j_end) {
        if (i_start > i_end || j_start > j_end) {
            return null;
        }
        if (i_start == i_end) {
            return new TreeNode(pre[i_start]);
        }
        TreeNode root = new TreeNode(pre[i_start]);
        int p = 0;
        while (j_start + p < j_end) {
            if (pre[i_start + 1] != post[j_start + p]) {
                p++;
            } else {
                break;
            }
        }
        root.left = constructHelper(pre, i_start + 1, i_start + p + 1, post, j_start, j_start + p);
        root.right = constructHelper(pre, i_start + p + 2, i_end, post, j_start + p + 1, j_end - 1);
        return root;
    }
}