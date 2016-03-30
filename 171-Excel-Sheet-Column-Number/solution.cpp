class Solution {
public:
    int titleToNumber(string s) {
        int length = s.size();
        if(length==0) return 0;
        int colNum = 0;
        for(int i = 0, exp = length-1; i < length; i++, exp--) {
            int shift = (int)(s.at(i)-'A'+1);
            colNum += shift*pow(26, exp);
        }
        return colNum;
    }
};