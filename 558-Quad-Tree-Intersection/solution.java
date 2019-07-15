/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1 == null && quadTree2 == null) {
            return null;
        }
        Node node = new Node();
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            node.isLeaf = true;
            node.val = quadTree1.val || quadTree2.val;
        } else if (!quadTree1.isLeaf && !quadTree2.isLeaf) {
            node.isLeaf = false;
            node.topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            node.topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            node.bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        } else if (quadTree1.isLeaf) {
            if (quadTree1.val == true) {
                node.isLeaf = true;
                node.val = true;
            } else {
                node.isLeaf = false;
                node.topLeft = intersect(quadTree1, quadTree2.topLeft);
                node.topRight = intersect(quadTree1, quadTree2.topRight);
                node.bottomLeft = intersect(quadTree1, quadTree2.bottomLeft);
                node.bottomRight = intersect(quadTree1, quadTree2.bottomRight);
            }
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val == true) {
                node.isLeaf = true;
                node.val = true;
            } else {
                node.isLeaf = false;
                node.topLeft = intersect(quadTree1.topLeft, quadTree2);
                node.topRight = intersect(quadTree1.topRight, quadTree2);
                node.bottomLeft = intersect(quadTree1.bottomLeft, quadTree2);
                node.bottomRight = intersect(quadTree1.bottomRight, quadTree2);
            }
        }
        if (!node.isLeaf && node.topLeft.val && node.topRight.val
                && node.bottomLeft.val && node.bottomRight.val) {
            node.isLeaf = true;
            node.val = true;
            node.topLeft = node.topRight = node.topLeft = node.bottomLeft = node.bottomRight = null;
        }
        return node;
    }
}