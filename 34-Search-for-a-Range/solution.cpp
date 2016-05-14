class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> results = {-1, -1};
        int size = nums.size();
        int left = 0;
        int right = size-1;
        if(left==right && results[0]==target) {
            results[0]=results[1]=0;
            return results;
        }
        int mid = right;
        while(left < right) {
            if(nums[mid]==target){
                left = right = mid;
                break;
            } else if(nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            mid=left+(right-left)/2;
        }
        if(nums[left]==target) {
            while(left>0 && nums[left-1]==target) left--;
            while(right<size-1 && nums[right+1]==target) right++;
            results[0] = left;
            results[1] = right;
        }
        return results;
    }
};