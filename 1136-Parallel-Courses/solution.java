class Solution {
    public int minimumSemesters(int N, int[][] relations) {
        int[] degrees = new int[N + 1];
        List<Integer>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] r : relations) {
            adjList[r[0]].add(r[1]);
            degrees[r[1]]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int n = 1; n <= N; n++) {
            if (degrees[n] == 0) {
                queue.offer(n);
            }
        }
        int sem = 0;
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            int s = queue.size();
            while (s-- > 0) {
                int cur = queue.poll();
                for (int next : adjList[cur]) {
                    if (--degrees[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sem++;
        }
        for (int n = 1; n <= N; n++) {
            if (degrees[n] > 0) {
                return -1;
            }
        }
        return sem;
    }
}