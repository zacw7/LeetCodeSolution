class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList();
        if (nums == null || nums.length == 0) {
            return ranges;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        int left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right] > nums[right - 1] + 1) {
                if (left == right - 1) {
                    ranges.add(String.valueOf(nums[left]));
                } else {
                    ranges.add(String.valueOf(nums[left]) + "->" + String.valueOf(nums[right - 1]));
                }
                left = right;
            }
            right++;
        }
        if (left == right - 1) {
            ranges.add(String.valueOf(nums[left]));
        } else {
            ranges.add(String.valueOf(nums[left]) + "->" + String.valueOf(nums[right - 1]));
        }

        return ranges;
    }
}