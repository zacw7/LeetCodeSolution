class Solution {
public:
    bool isPowerOfTwo(int n) {
        while(n&1) n = n>>1;
        return (n==0) ? true : false;
    }
};