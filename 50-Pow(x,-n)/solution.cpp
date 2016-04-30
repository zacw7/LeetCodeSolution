class Solution {
public:
    double myPow(double x, int n) {
        if(n==0) return 1;
        unsigned int exp = abs(n);
        double result = helper(x, exp);
        if(n < 0) return result = 1/result;
        return result;
    }
    
    double helper(double base, unsigned int exp) {
        if(exp==0) return 1;
        if(exp==1) return base;
        
        double result = helper(base, exp>>1); // equal to exp/2 but more efficient
        result *= result;
        if(exp & 0x1 == 1) result *= base;
        return result;
    }
};