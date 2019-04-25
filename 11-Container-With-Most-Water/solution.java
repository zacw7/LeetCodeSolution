class Solution {
    // two pointers
    // T: O(n)
    // S: O(1)
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }

        int max = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}