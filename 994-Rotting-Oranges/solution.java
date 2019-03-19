class Solution {
    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        Queue<Integer> rotQueue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) freshCount++;
                else if (grid[i][j] == 2) rotQueue.add(i * 10 + j);
            }
        }
        int minutes = 0, size = rotQueue.size();
        while (freshCount > 0) {
            if (size == 0) return -1;
            while (size-- > 0) {
                int rottenCell = rotQueue.poll();
                int i = rottenCell / 10, j = rottenCell % 10;
                int row = i - 1, coloum = j;
                if (i > 0 && grid[i - 1][j] == 1) {
                    freshCount--;
                    grid[i - 1][j] = 2;
                    rotQueue.add((i - 1) * 10 + j);
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    freshCount--;
                    grid[i + 1][j] = 2;
                    rotQueue.add((i + 1) * 10 + j);
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    freshCount--;
                    grid[i][j - 1] = 2;
                    rotQueue.add(i * 10 + j - 1);
                }
                if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                    freshCount--;
                    grid[i][j + 1] = 2;
                    rotQueue.add((i * 10 + j + 1));
                }
            }
            minutes++;
            size = rotQueue.size();
        }
        return minutes;
    }
}