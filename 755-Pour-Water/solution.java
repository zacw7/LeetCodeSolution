class Solution {
    // Simulation
    // T: O(V*N)
    // S: O(1)
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || heights.length == 0 || V == 0) {
            return heights;
        }

        while (V-- > 0) {
            int fall = K;
            // check left
            for (int i = K - 1; i >= 0; i--) {
                if (heights[i] < heights[fall]) {
                    fall = i;
                } else if (heights[i] > heights[fall]) {
                    break;
                }
            }
            if (fall < K) {
                heights[fall]++;
                continue;
            }
            // check right
            for (int i = K + 1; i < heights.length; i++) {
                if (heights[i] < heights[fall]) {
                    fall = i;
                } else if (heights[i] > heights[fall]) {
                    break;
                }
            }
            heights[fall]++;
        }

        return heights;
    }
}