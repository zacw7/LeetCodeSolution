class NumArray {

    private SegmentTreeNode root;

    public NumArray(int[] nums) {
        this.root = build(nums, 0, nums.length - 1);
    }

    public void update(int i, int val) {
        modify(root, i, val);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
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
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */