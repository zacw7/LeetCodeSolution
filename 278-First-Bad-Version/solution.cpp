// Forward declaration of isBadVersion API.
bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1;
        int left = 1;
        int right = n;
        int mid = left + (right - left)/2; // is equivalent to (left+right)/2 logically, but more likely to avoid data overflow
        
        while(left < mid) {
            if(isBadVersion(mid)) right = mid;
            else left = mid;
            mid = left + (right - left)/2;
        }
        return mid+1;
    }
};