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
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) sb.append("#").append(",");
        else {
            sb.append(String.valueOf(node.val)).append(",");
            serializeHelper(node.left, sb);
            serializeHelper(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 ) return null;
        int[] i = {0};
        String[] codes = data.split(",");
        return deserializeHelper(codes, i);
    }

    private TreeNode deserializeHelper(String[] codes, int[] i) {
        if (i[0] > codes.length || codes[i[0]].equals("#")) {
            i[0]++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(codes[i[0]++]));
            node.left = deserializeHelper(codes, i);
            node.right = deserializeHelper(codes, i);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));