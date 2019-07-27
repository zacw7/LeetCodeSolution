class Solution {
    public int largestUniqueNumber(int[] A) {
        int[] count = new int[1001];
        for (int n : A) {
            count[n]++;
        }
        for (int n = 1000; n >= 0; n--) {
            if (count[n] == 1) {
                return n;
            }
        }
        return -1;
    }
}