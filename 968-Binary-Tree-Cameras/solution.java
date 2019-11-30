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
        Pair p = cameraCover(root);
        if (p.state == -1) {
            return p.count + 1;
        } else {
            return p.count;
        }
    }


    private Pair cameraCover(TreeNode root) {
        Pair pair = new Pair(0, 0);
        if (root == null) {
            return pair;
        }
        Pair left = cameraCover(root.left);
        Pair right = cameraCover(root.right);
        pair.count = left.count + right.count;
        if (left.state == -1 || right.state == -1) {
            pair.state = 1;
            pair.count += 1;
        } else if (left.state == 1 || right.state == 1) {
            pair.state = 0;
        } else {
            pair.state = -1;
        }
        return pair;
    }

    /**
     * state
     * -1     -   need one
     *  0     -   covered by child
     *  1     -   placed
     */
    class Pair {
        int state, count;

        Pair(int state, int count) {
            this.state = state;
            this.count = count;
        }
    }
}