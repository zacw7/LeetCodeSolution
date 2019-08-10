class Solution {
    public int minSwaps(int[] data) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                count++;
            }
        }
        if (count <= 1) {
            return 0;
        }
        int cur = 0;
        int left = 0, right = count;
        for (int i = left; i < right; i++) {
            if (data[i] == 1) {
                cur++;
            }
        }
        int minSwap = count - cur;
        while (right < data.length) {
            if (data[left] == 1) {
                cur--;
            }
            if (data[right] == 1) {
                cur++;
            }
            left++;
            right++;
            minSwap = Math.min(minSwap, count - cur);
        }
        return minSwap;
    }
}