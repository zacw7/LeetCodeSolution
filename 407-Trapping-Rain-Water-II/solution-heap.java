class Solution {
    // Min-Heap
    // T: O(nlogn) - every cell will be visited only once. heap opeation is O(logn);
    // S: O(n) - heap used
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length <= 2 || heightMap[0].length <= 2) {
            return 0;
        }
        int R = heightMap.length, C = heightMap[0].length;
        int water = 0;
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> minHeap = new PriorityQueue<int[]>((o1, o2) -> heightMap[o1[0]][o1[1]] - heightMap[o2[0]][o2[1]]);
        for (int r = 0; r < R; r++) {
            if (r == 0 || r == R - 1) {
                for (int c = 0; c < C; c++) {
                    visited[r][c] = true;
                    minHeap.offer(new int[]{r, c});
                }
            } else {
                visited[r][0] = visited[r][C - 1] = true;
                minHeap.offer(new int[]{r, 0});
                minHeap.offer(new int[]{r, C - 1});
            }
        }
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int r = cur[0], c = cur[1];
            if(r > 0 && !visited[r - 1][c]) {
                visited[r - 1][c] = true;
                if (heightMap[r][c] > heightMap[r - 1][c]) {
                    water += heightMap[r][c] - heightMap[r - 1][c];
                    heightMap[r - 1][c] = heightMap[r][c];
                }
                minHeap.offer(new int[]{r - 1, c});
            }
            if(r + 1 < R && !visited[r + 1][c]) {
                visited[r + 1][c] = true;
                if (heightMap[r][c] > heightMap[r + 1][c]) {
                    water += heightMap[r][c] - heightMap[r + 1][c];
                    heightMap[r + 1][c] = heightMap[r][c];
                }
                minHeap.offer(new int[]{r + 1, c});
            }
            if(c > 0 && !visited[r][c - 1]) {
                visited[r][c - 1] = true;
                if (heightMap[r][c] > heightMap[r][c - 1]) {
                    water += heightMap[r][c] - heightMap[r][c - 1];
                    heightMap[r][c - 1] = heightMap[r][c];
                }
                minHeap.offer(new int[]{r, c - 1});
            }
            if(c + 1 < C && !visited[r][c + 1]) {
                visited[r][c + 1] = true;
                if (heightMap[r][c] > heightMap[r][c + 1]) {
                    water += heightMap[r][c] - heightMap[r][c + 1];
                    heightMap[r][c + 1] = heightMap[r][c];
                }
                minHeap.offer(new int[]{r, c + 1});
            }
        }
        return water;
    }
}