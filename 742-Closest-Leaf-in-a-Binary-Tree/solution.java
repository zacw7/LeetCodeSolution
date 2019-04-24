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

    Map<TreeNode, TreeNode> parentMap = new HashMap();
    int res = 0;
    int minDist = Integer.MAX_VALUE;

    public int findClosestLeaf(TreeNode root, int k) {
        TreeNode node = find(root, k);
        int dist = 0;
        distToLeaf(node, 0);
        while (parentMap.containsKey(node)) {
            TreeNode parent = parentMap.get(node);
            if (node == parent.left && parent.right != null) {
                distToLeaf(parent.right, dist + 2);
            } else if (node == parent.right && parent.left != null) {
                distToLeaf(parent.left, dist + 2);
            }
            dist++;
            node = parent;
        }
        return res;
    }

    private void distToLeaf(TreeNode node, int dist) {
        if (node.left == null && node.right == null) {
            if (dist < minDist) {
                minDist = dist;
                res = node.val;
            }
        }
        if (node.left != null) {
            distToLeaf(node.left, dist + 1);
        }
        if (node.right != null) {
            distToLeaf(node.right, dist + 1);
        }
    }

    private TreeNode find(TreeNode node, int k) {
        if (node == null) {
            return null;
        } else if (node.val == k) {
            return node;
        }
        if (node.left != null) {
            parentMap.put(node.left, node);
            TreeNode left = find(node.left, k);
            if (left != null) {
                return left;
            }
        }
        if (node.right != null) {
            parentMap.put(node.right, node);
            TreeNode right = find(node.right, k);
            if (right != null) {
                return right;
            }
        }
        return null;
    }
}