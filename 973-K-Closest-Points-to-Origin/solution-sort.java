class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> Math.abs(o1[0] * o1[0] + o1[1] * o1[1]) - Math.abs(o2[0] * o2[0] + o2[1] * o2[1]));
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }
}