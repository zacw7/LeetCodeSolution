class Solution {

    class SegmentTreeNode {
        int start, end, count;
        SegmentTreeNode left, right;

        SegmentTreeNode(int start, int end , int count) {
            this.start = start;
            this.end = end;
            this.count = count;
            this.left = this.right = null;
        }
    }

    private SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end, 0);
        if (start != end) {
            int mid = start + (end - start) / 2;
            node.left = build(start, mid);
            node.right = build(mid + 1, end);
        }

        return node;
    }

    private int modify(SegmentTreeNode node, int element) {
        if (element < node.start || element > node.end) {
            return node.count;
        }

        if (node.start == node.end) {
            node.count++;
        } else {
            node.count = modify(node.left, element) + modify(node.right, element);
        }
        return node.count;
    }

    private int query(SegmentTreeNode node, int start, int end) {
        // no common
        if (start > node.end || end < node.start) {
            return 0;
        }

        // include
        if (start <= node.start && end >= node.end) {
            return node.count;
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

    public List<Integer> countSmaller(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        SegmentTreeNode root = build(min, max);
        List<Integer> ans = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            ans.add(query(root, Integer.MIN_VALUE, nums[i] - 1));
            modify(root, nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}