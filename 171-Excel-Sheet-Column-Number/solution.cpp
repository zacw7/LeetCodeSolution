class Solution {
public:
    int titleToNumber(string s) {
        int colNum = 0;
        int length = s.size();
        for(int i = 0, exp = length-1; i < length; i++, exp--) {
            int shift = (int)(s.at(i)-'A'+1);
            colNum += shift*pow(26, exp);
        }
        return colNum;
    }
};