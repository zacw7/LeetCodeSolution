class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (o1, o2) -> o1[1] - o2[1]);
        int bound = pairs[0][1], count = 1;
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > bound) {
                count++;
                bound = pairs[i][1];
            }
        }
        return count;
    }
}