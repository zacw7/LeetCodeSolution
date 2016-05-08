class Solution {
public:
    int strStr(string haystack, string needle) {
        int haystackSize = haystack.size();
        int needleSize = needle.size();
        if(needleSize > haystackSize) return -1;
        
        for(int i = 0; i <= haystackSize-needleSize; i++) {
            int offset = 0;
            while(needle[offset] == haystack[i+offset] && offset < needleSize) {
                offset++;
            }
            if (offset==needleSize) return i;
        }
        
        return -1;
    }
};