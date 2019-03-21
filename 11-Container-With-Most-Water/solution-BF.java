class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int cur = Math.min(height[i], height[j]) * (j - i);
                if (cur > max) max = cur;
            }
        }
        return max;
    }
}