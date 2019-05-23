class Solution {
    // TC: O(MN)
    // SC: O(1)
    public int findRadius(int[] houses, int[] heaters) {
        int radius = 0;
        for (int house : houses) {
            int cur = Integer.MAX_VALUE;
            for (int heater : heaters) {
                cur = Math.min(cur, Math.abs(house - heater));
            }
            radius = Math.max(radius, cur);
        }
        return radius;
    }
}