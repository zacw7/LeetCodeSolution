class NumMatrix {

    private SegmentTreeNode root;
    private int R, C;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        // convert 2D matrix to 1D array
        this.R = matrix.length;
        this.C = matrix[0].length;
        int[] array = new int[R * C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                array[i * C + j] = matrix[i][j];
            }
        }
        this.root = build(array, 0, array.length - 1);
    }

    public void update(int row, int col, int val) {
        modify(root, row * C + col, val);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int r = row1; r <= row2; r++) {
            sum += query(root, r * C + col1, r * C + col2);
        }
        return sum;
    }

    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = this.right = null;
        }
    }

    private SegmentTreeNode build(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    private int modify(SegmentTreeNode node, int index, int val) {
        if (index < node.start || index > node.end) {
            return node.sum;
        }

        if (node.start == node.end) {
            node.sum = val;
        } else {
            node.sum = modify(node.left, index, val) + modify(node.right, index, val);
        }
        return node.sum;
    }

    private int query(SegmentTreeNode node, int start, int end) {
        if (end < node.start || start > node.end) {
            return 0;
        }

        if (start <= node.start && end >= node.end) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (start <= mid) {
            if (end <= mid) {
                return query(node.left, start, end);
            } else {
                return query(node.left, start, mid) + query(node.right, mid + 1, end);
            }
        } else {
            return query(node.right, start, end);
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */