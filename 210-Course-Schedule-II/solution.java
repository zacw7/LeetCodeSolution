class Solution {
    // T: O(n)
    // S: O(n)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] indegrees = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];

        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            if (adjList[pre[1]] == null) {
                adjList[pre[1]] = new ArrayList();
            }
            adjList[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order[index++] = curr;
            if (adjList[curr] != null) {
                for (int neighbor : adjList[curr]) {
                    indegrees[neighbor]--;
                    if (indegrees[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }

        if (index < numCourses) {
            return new int[0];
        }
        return order;
    }
}