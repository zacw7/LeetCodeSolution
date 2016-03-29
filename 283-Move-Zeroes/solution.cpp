class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int size = nums.size();
        if(size == 0) return;
        int left, right;
        left = right = 0;
        while(right < size) {
            if(nums[left]==0 && nums[right]!=0) {
                nums[left] = nums[right];
                nums[right] = 0;
            }
            if(nums[left]) left++;
            right++;
        }
    }
};