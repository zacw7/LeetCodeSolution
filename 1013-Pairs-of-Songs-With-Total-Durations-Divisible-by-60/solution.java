class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] durations = new int[60];
        for (int t : time) durations[t % 60] ++;
        int count = 0;
        count += (durations[0] * (durations[0] - 1)) >> 1;
        count += (durations[30] * (durations[30] - 1)) >> 1;
        for (int i = 1; i < 30; i++) count += durations[i] * durations[60 - i];
        return count;
    }
}