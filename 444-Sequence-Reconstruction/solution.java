class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        if (org == null || org.length == 0) {
            return false;
        }
        int N = org.length;
        List<Integer>[] adjList = new List[N + 1];
        int[] degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        boolean empty = true;
        for (List<Integer> seq : seqs) {
            int prev = -1;
            for (int n : seq) {
                if (n > N || n < 0) {
                    return false;
                }
                empty = false;
                if (prev != -1) {
                    adjList[prev].add(n);
                    degree[n]++;
                }
                prev = n;
            }
        }
        if (empty) {
            return false;
        }
        int idx = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.toString());
            if (queue.size() > 1 || idx >= N || queue.peek() != org[idx++]) {
                return false;
            }
            int cur = queue.poll();
            for (int next : adjList[cur]) {
                if (--degree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return idx == N;
    }
}