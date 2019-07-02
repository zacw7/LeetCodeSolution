class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, delta = Integer.MAX_VALUE;
        for (int[] n : nuts) {
            int treeDist = Math.abs(tree[0] - n[0]) + Math.abs(tree[1] - n[1]);
            int sqrlDist = Math.abs(squirrel[0] - n[0]) + Math.abs(squirrel[1] - n[1]);
            dist += 2 * treeDist;
            delta = Math.min(delta, sqrlDist - treeDist);
        }
        return dist + delta;
    }
}