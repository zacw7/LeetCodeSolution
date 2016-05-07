class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int size = nums.size();
        int peakIndex = 0;
        int i = 1;
        while(i < size) {
            if(nums[peakIndex] > nums[i]) break;
            else {
                peakIndex = i++;
            }
        }
        return peakIndex;
    }
};