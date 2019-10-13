class Solution {
    // Sort
    // Time: O(nlogn)
    // Space: O(1)
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1, p2) -> (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}