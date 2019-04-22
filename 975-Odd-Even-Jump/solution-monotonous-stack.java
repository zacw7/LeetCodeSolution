class Solution {
    // dp + monotonous stack
    // T: O(n^2)
    // S: O(n)
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // dp[i][0]: whether i is a good index after an even jump
        // dp[i][1]: whether j is a good index after an odd jump
        boolean[][] dp = new boolean[A.length][2];
        dp[A.length - 1][0] = dp[A.length - 1][1] = true;
        Stack<Integer> monoIncrStack = new Stack();
        Stack<Integer> monoDescStack = new Stack();
        monoIncrStack.push(A.length - 1);
        monoDescStack.push(A.length - 1);
        for (int i = A.length - 2; i >= 0; i--) {
            Stack<Integer> tmp = new Stack();
            // for dp[i][0], the next jump is an odd jump.
            // if the next position(after an odd jump) is good, then i is good
            // the next position: the smallest value which is larger than A[i]
            // => a monotonous decreasing stack can help
            while (!monoDescStack.isEmpty() && A[monoDescStack.peek()] < A[i]) {
                tmp.push(monoDescStack.pop());
            }

            if (monoDescStack.isEmpty()) {
                dp[i][0] = false;
            } else {
                dp[i][0] = dp[monoDescStack.peek()][1];
            }
            monoDescStack.push(i);
            while (!tmp.isEmpty()) {
                monoDescStack.push(tmp.pop());
            }
            // for dp[i][1], the next jump is an even jump.
            // if the next position(after an even jump) is good, then i is good
            // the next position: the largest value which is smaller than A[i]
            // => a monotonous increasing stack can help
            while (!monoIncrStack.isEmpty() && A[monoIncrStack.peek()] > A[i]) {
                tmp.push(monoIncrStack.pop());
            }
            if (monoIncrStack.isEmpty()) {
                dp[i][1] = false;
            } else {
                dp[i][1] = dp[monoIncrStack.peek()][0];
            }
            monoIncrStack.push(i);
            while (!tmp.isEmpty()) {
                monoIncrStack.push(tmp.pop());
            }
        }

        // count the good indexes
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (dp[i][0]) {
                count++;
            }
        }
        return count;
    }
}