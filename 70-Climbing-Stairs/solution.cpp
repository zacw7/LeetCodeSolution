class Solution {
public:
    int climbStairs(int n) {
        if(n <= 0) return 0;
        vector<int> waysToClimb;
        waysToClimb.push_back(1);
        waysToClimb.push_back(2);
        for(int i = 2; i < n; i++) {
            waysToClimb.push_back(waysToClimb.at(i-2)+waysToClimb.at(i-1));
        }
        return waysToClimb.at(n-1);
    }
};