class Solution {
public:
    string convertToTitle(int n) {
        if(n <= 0) return ""; 
        int shift = n%26;
        if(shift == 0) {
            shift = 26;
        }
        return convertToTitle((n-shift)/26) + (char)('A'+shift-1);;
    }
};