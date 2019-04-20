class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int dist = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            if (dist >= Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1])) {
                return false;
            }
        }
        return true;
    }
}