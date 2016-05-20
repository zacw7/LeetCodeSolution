class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        bool result = false;
        int size1 = s1.size();
        int size2 = s2.size();
        int size3 = s3.size();
        if(size1+size2 == size3) result = helper(0, 0, 0, s1, s2, s3, size1, size2, size3);
        return result;
    }
    
    bool helper(int p1, int p2, int p3, string &s1, string &s2, string &s3, int size1, int size2, int size3) {
        if(p3==size3) return true;
        if(p1<size1 && s3[p3]==s1[p1] && helper(p1+1, p2, p3+1, s1, s2, s3, size1, size2, size3)) return true;
        if(p2<size2 && s3[p3]==s2[p2] && helper(p1, p2+1, p3+1, s1, s2, s3, size1, size2, size3)) return true;
        
        return false;
    }
};