class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int size = nums.size();
        int peak = nums[0];
        int i = 1;
        while(i < size) {
            if(peak > nums[i]) break;
            else {
                peak = nums[i];
                i+1;
            }
        }
        return peak;
    }
};