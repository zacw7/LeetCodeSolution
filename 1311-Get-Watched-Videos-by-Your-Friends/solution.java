class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int N = watchedVideos.size();
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList();
        visited[id] = true;
        queue.offer(id);
        while (!queue.isEmpty() && level-- > 0) {
            int sz = queue.size();
            while (sz-- > 0) {
                int cur = queue.poll();
                for (int neigh : friends[cur]) {
                    if (visited[neigh]) {
                        continue;
                    }
                    visited[neigh] = true;
                    queue.offer(neigh);
                }
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (String vid : watchedVideos.get(cur)) {
                map.put(vid, map.getOrDefault(vid, 0) + 1);
            }
        }
        List<String> res = new ArrayList(map.keySet());
        Collections.sort(res, (a, b) -> (map.get(a) == map.get(b)) ? a.compareTo(b) : map.get(a) - map.get(b));
        return res;
    }
}