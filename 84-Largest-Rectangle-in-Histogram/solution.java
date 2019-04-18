class Solution {
    // T: O(n) - three passes
    // S: O(n) - the worst case: n = heights.length;
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int[] left = new int[heights.length], right = new int[heights.length];
        Stack<Integer> monoIncrStack = new Stack();
        for (int i = 0; i < heights.length; i++) {
            while (!monoIncrStack.isEmpty() && heights[i] <= heights[monoIncrStack.peek()]) {
                monoIncrStack.pop();
            }
            if (monoIncrStack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = monoIncrStack.peek();
            }
            monoIncrStack.push(i);
        }
        monoIncrStack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!monoIncrStack.isEmpty() && heights[i] <= heights[monoIncrStack.peek()]) {
                monoIncrStack.pop();
            }
            if (monoIncrStack.isEmpty()) {
                right[i] = heights.length;
            } else {
                right[i] = monoIncrStack.peek();
            }
            monoIncrStack.push(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
        }

        return max;
    }
}