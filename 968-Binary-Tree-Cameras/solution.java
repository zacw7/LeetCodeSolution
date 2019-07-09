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
    public int minCameraCover(TreeNode root) {
        int[] res = dfs(root);
        if (res[1] == 2) {
            res[0]++;
        }
        return res[0];
    }

    // res[0] -  number of camera placed
    // res[1] - state:
    // 0: no need camera, no camera placed
    // 1: no need camera, a camera placed
    // 2: need a camera
    private int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            res[1] = 0;
        } else if (node.left == null && node.right == null) {
            res[1] = 2;
        } else {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            if (left[1] == 2 || right[1] == 2) {
                res[0] = left[0] + right[0] + 1;
                res[1] = 1;
            } else if (left[1] == 1 || right[1] == 1) {
                res[0] = left[0] + right[0];
                res[1] = 0;
            } else {
                res[0] = left[0] + right[0];
                res[1] = 2;
            }
        }
        return res;
    }

    class State {
        int count;
        boolean needCamera;

        State() {
            this.count = 0;
            this.needCamera = false;
        }
    }
}