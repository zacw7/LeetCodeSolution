// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        long left = 1;
        long right = n;
        long mid = (left+right)/2;
        
        while(left < mid) {
            if(isBadVersion(mid)) right = mid;
            else left = mid;
            mid = (left+right)/2;
        }
        return mid+1;
    }
};