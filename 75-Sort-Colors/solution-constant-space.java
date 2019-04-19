class Solution {
    // T: O(1) - one pass
    // S: O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else if (nums[left] == 2 || nums[right] == 0) {
                swap(nums, left, right);
            } else if (nums[left] == 1 && nums[right] == 1) {
                int tmp = left + 1;
                while (tmp < right) {
                    if (nums[tmp] == 0) {
                        swap(nums, left, tmp);
                        break;
                    } else if (nums[tmp] == 2) {
                        swap(nums, right, tmp);
                        break;
                    } else {
                        tmp++;
                    }
                }
                if (tmp == right) {
                    break;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}