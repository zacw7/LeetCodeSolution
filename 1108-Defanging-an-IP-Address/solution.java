class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] b : bookings) {
            int from = b[0] - 1, to = b[1], seat = b[2];
            ans[b[0] - 1] += seat;
            if (b[1] < n) {
                ans[b[1]] -= seat;
            }
        }
        int seat = ans[0];
        for (int i = 1; i < n; i++) {
            seat = ans[i - 1] + ans[i];
            ans[i] = seat;
        }
        return ans;
    }
}