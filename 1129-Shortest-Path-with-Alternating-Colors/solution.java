class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        List<Integer>[] adjRed = new List[n];
        List<Integer>[] adjBlue = new List[n];
        for (int i = 0; i < n; i++) {
            adjRed[i] = new ArrayList();
            adjBlue[i] = new ArrayList();
        }
        for (int[] r_e : red_edges) {
            int s = r_e[0], e = r_e[1];
            adjRed[s].add(e);
        }
        for (int[] b_e : blue_edges) {
            int s = b_e[0], e = b_e[1];
            adjBlue[s].add(e);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        boolean[][] visited = new boolean[n][2];
        // BFS: color: 0-red, 1-blue
        ans[0] = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        visited[0][0] = visited[0][1] = true;
        int len = 0;
        while(!queue.isEmpty()) {
            len++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int node = cur[0], color = cur[1];
                // red
                List<Integer> adjList = adjRed[node];
                if (color == 1) {
                    // cur: blue
                    adjList = adjBlue[node];
                }
                int nextColor = 1 - color;
                for (int neigh : adjList) {
                    if (visited[neigh][nextColor]) {
                        continue;
                    }
                    if (ans[neigh] == -1) {
                        ans[neigh] = len;
                    }
                    visited[neigh][nextColor] = true;
                    queue.offer(new int[]{neigh, nextColor});
                }
            }
        }
        return ans;
    }

}