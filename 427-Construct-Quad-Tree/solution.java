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
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return null;
        }
        return constructHelper(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    private Node constructHelper(int[][] grid, int r1, int c1, int r2, int c2) {
        int val = grid[r1][c1];
        Node node = new Node(val == 1, true, null, null, null, null);
        for (int r = r1; r <= r2; r++) {
            for (int c = c1; c <= c2; c++) {
                if (grid[r][c] != val) {
                    node.isLeaf = false;
                    break;
                }
            }
            if (!node.isLeaf) {
                break;
            }
        }

        if (!node.isLeaf) {
            int rm = r1 + (r2 - r1) / 2;
            int cm = c1 + (c2 - c1) / 2;
            node.topLeft = constructHelper(grid, r1, c1, rm, cm);
            node.topRight = constructHelper(grid, r1, cm + 1, rm, c2);
            node.bottomLeft = constructHelper(grid, rm + 1, c1, r2, cm);
            node.bottomRight = constructHelper(grid, rm + 1, cm + 1, r2, c2);
        }

        return node;
    }
}