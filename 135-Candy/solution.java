class Solution {
    // Time: O(n) - every element will be visited twice
    // Space: O(n) - an array used
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int minRate = Integer.MAX_VALUE;
        for (int r : ratings) {
            minRate = Math.min(minRate, r);
        }
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (ratings[i] == minRate || i == 0 || i == ratings.length - 1) {
                candies[i] = Math.max(candies[i], 1);
                // left
                for (int l = i - 1; l >= 0 && ratings[l] != minRate; l--) {
                    if (ratings[l] > ratings[l + 1]) {
                        candies[l] = Math.max(candies[l], candies[l + 1] + 1);
                    } else {
                        candies[l] = Math.max(candies[l], 1);
                    }
                }
                // right
                for (int r = i + 1; r < ratings.length && ratings[r] != minRate; r++) {
                    if (ratings[r] > ratings[r - 1]) {
                        candies[r] = Math.max(candies[r], candies[r - 1] + 1);
                    } else {
                        candies[r] = Math.max(candies[r], 1);
                    }
                }
            }
        }
        int sum = 0;
        for (int c : candies) {
            sum += c;
        }
        return sum;
    }
}