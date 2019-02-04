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
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        if (t != null) {
            sb.append(String.valueOf(t.val));
            if (t.left != null || t.right != null) {
                if (t.left != null) {
                    inorder(sb, t.left);
                } else {
                    sb.append('(');
                    sb.append(')');
                }
                if (t.right != null) {
                    inorder(sb, t.right);
                }
            }
        }
        return sb.toString();
    }

    private StringBuilder inorder(StringBuilder sb, TreeNode t) {
        sb.append('(');
        sb.append(String.valueOf(t.val));
        if (t.left != null || t.right != null) {
            if (t.left != null) {
                inorder(sb, t.left);
            } else {
                sb.append('(');
                sb.append(')');
            }
            if (t.right != null) {
                inorder(sb, t.right);
            }
        }
        sb.append(')');
        return sb;
    }
}