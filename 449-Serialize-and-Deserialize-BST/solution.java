/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(',');
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] str = data.split(",");
        int[] vals = new int[str.length];
        for (int i = 0; i < vals.length; i++) vals[i] = Integer.valueOf(str[i]);
        return construct(vals, 0, vals.length - 1);
    }

    private TreeNode construct(int[] vals, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(vals[start]);
        if (start < end) {
            int divide = start + 1;
            while (divide <= end && vals[divide] < vals[start]) divide++;
            node.left = construct(vals, start + 1, divide - 1);
            node.right = construct(vals, divide, end);
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));