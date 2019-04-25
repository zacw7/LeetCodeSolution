/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        if (root.children != null && !root.children.isEmpty()) {
            sb.append("[");
            List<String> list = new ArrayList();
            for (Node child : root.children) {
                list.add(serialize(child));
            }
            sb.append(String.join(",", list));
            sb.append("]");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        int idx = 0;
        while (idx < data.length() && Character.isDigit(data.charAt(idx))) {
            idx++;
        }
        Node node = new Node(Integer.valueOf(data.substring(0, idx)));
        node.children = new ArrayList();
        if (idx < data.length()) {
            int prev = idx + 1;
            idx++;
            int left = 0;
            while (idx < data.length()) {
                if ((data.charAt(idx) == ',' || idx == data.length() - 1) && left == 0) {
                    node.children.add(deserialize(data.substring(prev, idx)));
                    prev = idx + 1;
                } else if (data.charAt(idx) == '[') {
                    left++;
                } else if (data.charAt(idx) == ']') {
                    left--;
                }
                idx++;
            }
        }
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));