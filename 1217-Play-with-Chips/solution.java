class Solution {
    public int minCostToMoveChips(int[] chips) {
        int count = 0;
        for (int c :chips) {
            if (c % 2 == 0) {
                count++;
            }
        }
        return Math.min(count, chips.length - count);
    }
}