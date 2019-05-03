class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList();
        if (lower > upper) {
            return ans;
        }
        long prev = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < prev) {
                continue;
            } else if (prev == nums[i]) {
                prev++;
            } else {
                // missing range found
                int n = (nums[i] > upper) ? upper + 1 : nums[i];
                if (prev == n - 1) {
                    ans.add(String.valueOf(prev));
                } else if (prev < n - 1) {
                    ans.add(prev + "->" + (n - 1));
                }
                prev = (long) n + 1;
            }
            if (prev > upper) {
                break;
            }
        }

        if (prev == upper) {
            ans.add(String.valueOf(prev));
        } else if (prev < upper) {
            ans.add(prev + "->" + (upper));
        }
        return ans;
    }
}