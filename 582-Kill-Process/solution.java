class Solution {
    // T: O(n)
    // S: O(n)
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if(pid.size() == 0 || ppid.size() == 0 || kill == 0) return new ArrayList();
        Set<Integer> ans = new HashSet();
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0, size = pid.size(); i < size; i++) {
            int parent = ppid.get(i), child = pid.get(i);
            List<Integer> childrenList = map.getOrDefault(parent, new ArrayList());
            childrenList.add(child);
            map.put(parent, childrenList);
        }
        Queue<Integer> queue = new LinkedList();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!ans.contains(cur)) {
                if (map.containsKey(cur)) {
                    List<Integer> children = map.get(cur);
                    for (Integer child : children) queue.add(child);
                }
                ans.add(cur);
            }
        }
        return new ArrayList(ans);
    }
}