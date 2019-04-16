class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }

        int prev = 0;
        while (prev < seats.length && seats[prev] == 0) {
            prev++;
        }
        int max = prev - 0;
        for (int i = prev + 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                max = Math.max(max, (i - prev) / 2);
                prev = i;
            }
        }
        max = Math.max(max, seats.length - 1 - prev);
        return max;
    }
}