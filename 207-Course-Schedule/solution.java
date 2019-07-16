class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] p : prerequisites) {
            indegrees[p[0]]++;
            adjList[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adjList[cur]) {
                if (indegrees[neighbor] == 1) {
                    queue.offer(neighbor);
                }
                indegrees[neighbor]--;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] > 0) {
                return false;
            }
        }
        return true;
    }
}