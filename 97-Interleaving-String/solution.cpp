class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        bool result = false;
        if(s1.size()+s2.size() == s3.size()) result = helper(0, 0, 0, s1, s2, s3);
        return result;
    }
    
    bool helper(int p1, int p2, int p3, string &s1, string &s2, string &s3) {
        if(p3==s3.size()) return true;
        bool r1, r2; 
        r1 = r2 = false;
        
        if(p1<s1.size() && s3[p3]==s1[p1]) {
            r1 = helper(p1+1, p2, p3+1, s1, s2, s3);
        }
        if(p2<s2.size() && s3[p3]==s2[p2]) {
            r2 = helper(p1, p2+1, p3+1, s1, s2, s3);
        }
        return r1||r2;
    }
};