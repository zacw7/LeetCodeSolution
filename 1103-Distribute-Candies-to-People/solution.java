class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int r = 0, i = 0;
        while (candies > 0) {
            if (i == num_people) {
                r++;
                i = 0;
            }
            int d = r * num_people + i + 1;
            if (d >= candies) {
                d = candies;
            }
            ans[i++] += d;
            candies -= d;
        }
        return ans;
    }
}