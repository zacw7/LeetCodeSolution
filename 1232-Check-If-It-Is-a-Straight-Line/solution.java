class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], x2 = coordinates[1][0];
        int y1 = coordinates[0][1], y2 = coordinates[1][1];
        if (x1 == x2) {
            for (int i = 2 ; i < coordinates.length; i++) {
                int x = coordinates[i][0], y = coordinates[i][1];
                if (x != x1) {
                    return false;
                }
            }
            return true;
        } else if (y1 == y2) {
            for (int i = 2 ; i < coordinates.length; i++) {
                int x = coordinates[i][0], y = coordinates[i][1];
                if (y != y1) {
                    return false;
                }
            }
            return true;
        } else {
            double a = 1.0 * (y1 - y2) / (x1 - x2);
            double b = y1 - a * x1;
            for (int i = 2 ; i < coordinates.length; i++) {
                int x = coordinates[i][0], y = coordinates[i][1];
                if (y != x * a + b) {
                    return false;
                }
            }
            return true;
        }
    }
}