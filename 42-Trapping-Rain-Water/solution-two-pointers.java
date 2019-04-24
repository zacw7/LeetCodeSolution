class Solution {
    // two pointers
    // T: O(n)
    // S: O(1)
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int water = 0;
        int left = 0, right = height.length - 1;
        while (left < right - 1) {
            if (height[left] <= height[right]) {
                int p = left + 1;
                while (height[p] < height[left]) {
                    water += height[left] - height[p];
                    p++;
                }
                left = p;
            } else {
                int p = right - 1;
                while (height[p] < height[right]) {
                    water += height[right] - height[p];
                    p--;
                }
                right = p;
            }
        }
        return water;
    }
}