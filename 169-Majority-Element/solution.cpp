class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int size = nums.size();
        int majorityEle = nums.at(0);
        int count = 1;
        
        for(int i = 1; i < size; i++) {
            if(count) {
                if(majorityEle == nums.at(i)) {
                    count++;
                } else {
                    count--;
                }
            } else {
                majorityEle = nums.at(i);
                count++;
            }
        }
        
        return majorityEle;
    }
};