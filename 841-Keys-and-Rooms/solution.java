class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList();
        visited[0] = true;
        for (int key : rooms.get(0)) {
            queue.offer(key);
        }
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (!visited[room]) {
                visited[room] = true;
                for (int key : rooms.get(room)) {
                    queue.offer(key);
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}