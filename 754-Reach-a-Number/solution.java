class Solution {
    public int reachNumber(int target) {
        if (target < 0) {
            target = 0 - target;
        }
        int n = 1, sum = 0;
        while (true) {
            sum += n;
            int offset = sum - target;
            if (offset == 0 || (offset > 0 && offset % 2 == 0)) return n;
            n++;
        }
    }
}