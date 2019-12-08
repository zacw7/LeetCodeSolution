class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int N = groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < N; i++) {
            int sz = groupSizes[i];
            List<Integer> list = map.getOrDefault(sz, new ArrayList());
            list.add(i);
            map.put(sz, list);
        }
        List<List<Integer>> res = new ArrayList();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int sz = entry.getKey();
            List<Integer> ids = entry.getValue();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < ids.size(); i++) {
                if (i % sz == 0) {
                    list = new ArrayList();
                    res.add(list);
                }
                list.add(ids.get(i));
            }
        }
        return res;
    }
}