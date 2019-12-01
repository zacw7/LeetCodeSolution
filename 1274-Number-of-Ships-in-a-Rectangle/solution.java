/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        if (!sea.hasShips(topRight, bottomLeft)) {
            return 0;
        }
        int deltaX = topRight[0] - bottomLeft[0];
        int deltaY = topRight[1] - bottomLeft[1];
        if (deltaX == 0 && deltaY == 0) {
            return 1;
        } else if (deltaX > deltaY) {
            int midX = bottomLeft[0] + deltaX / 2;
            return countShips(sea, new int[]{midX, topRight[1]}, bottomLeft)
                    + countShips(sea, topRight, new int[]{midX + 1, bottomLeft[1]});
        } else {
            int midY = bottomLeft[1] + deltaY / 2;
            return countShips(sea, new int[]{topRight[0], midY}, bottomLeft)
                    + countShips(sea, topRight, new int[]{bottomLeft[0], midY + 1});
        }
    }
}