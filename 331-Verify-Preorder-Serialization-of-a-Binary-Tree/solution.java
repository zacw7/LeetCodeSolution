class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] nodes = preorder.split(",");
        return traverseHelper(nodes, 0) == nodes.length;
    }

    private int traverseHelper(String[] nodes, int i) {
        if (i >= nodes.length) {
            return nodes.length + 1;
        }
        if (!nodes[i++].equals("#")) {
            // traverseLeft
            i = traverseHelper(nodes, i);
            // traverseRight
            i = traverseHelper(nodes, i);
        }
        return i;
    }
}