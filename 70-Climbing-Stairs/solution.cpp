class Solution {
public:
    int climbStairs(int n) {
        if(n <= 0) return 0;
        int pre, ways;
        pre = 0; ways = 1;
        for(int i = 0; i < n; i++) {
            ways += pre;
            pre = ways-pre;
        }
        return ways;
    }
};