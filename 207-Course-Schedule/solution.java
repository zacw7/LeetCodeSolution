class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];

        for (int[] pre : prerequisites) {
            inDegree[pre[0]]++;
            if (adjList[pre[1]] == null) {
                adjList[pre[1]] = new ArrayList();
            }
            adjList[pre[1]].add(pre[0]);
        }

        while (numCourses > 0) {
            int pick = -1;
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    pick = i;
                    inDegree[i] = -1;
                    if (adjList[i] != null) {
                        for (int n : adjList[i]) {
                            inDegree[n]--;
                        }
                    }
                    break;
                }
            }
            if (pick == -1) {
                break;
            } else {
                numCourses--;
            }
        }

        return numCourses == 0;
    }
}