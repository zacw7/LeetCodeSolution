class Solution {
public:
    string reverseString(string s) {
        int length = s.length();
        if(length <= 1) return s;
        
        int left = 0;
        int right = length-1;
        
        while(left < right) {
            char temp = s.at(left);
            s.at(left) = s.at(right);
            s.at(right) = temp;
            left++;
            right--;
        }
        
        return s;
    }
};