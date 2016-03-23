class Solution {
public:
    bool isHappy(int n) {
        int num=0;
        while(n!=1&&n!=4) {
            while(n) {
                num += (n%10) * (n%10);
                n/=10;
            }
            n=num;num=0;
            
        }
        return 1==n;
    }
};