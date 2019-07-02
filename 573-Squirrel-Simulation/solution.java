class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Map<Integer, Integer> nutsIndex = new HashMap();
        for (int i = 0; i < nuts.length; i++) {
            nutsIndex.put(nuts[i][0] * width + nuts[i][1], i);
        }
        int[] treeDist = new int[nuts.length];
        boolean[] visited = new boolean[height * width];
        Queue<Integer> queue = new LinkedList();
        queue.offer(tree[0] * width + tree[1]);
        visited[tree[0] * width + tree[1]] = true;
        int dist = 0, diff = Integer.MAX_VALUE;
        while (!queue.isEmpty() && !nutsIndex.isEmpty()) {
            dist++;
            int s = queue.size();
            while (s-- > 0 && !nutsIndex.isEmpty()) {
                int pos = queue.poll();
                for (int[] d : dir) {
                    int x = pos / width + d[0], y = pos % width + d[1];
                    int cur = x * width + y;
                    if (x >= 0 && x < height && y >= 0 && y < width && !visited[cur]) {
                        visited[cur] = true;
                        queue.offer(cur);
                        if (nutsIndex.containsKey(cur)) {
                            treeDist[nutsIndex.get(cur)] = dist;
                            nutsIndex.remove(cur);
                            int sqrlDist = Math.abs(x - squirrel[0]) + Math.abs(y - squirrel[1]);
                            diff = Math.min(diff, sqrlDist - dist);
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int d : treeDist) {
            sum += d * 2;
        }
        sum = sum + diff;
        return sum;
    }
}