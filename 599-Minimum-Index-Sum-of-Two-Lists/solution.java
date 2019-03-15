class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Set<String> common = new HashSet();
        Map<String, Integer> idxMap = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            idxMap.put(list1[i], i);
        }
        for (int j = 0; j < list2.length; j++) {
            if (idxMap.keySet().contains(list2[j])) {
                common.add(list2[j]);
                idxMap.put(list2[j], idxMap.get(list2[j]) + j);
            }
        }
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList();
        for (String rest : common) {
            int cur = idxMap.get(rest);
            if (cur <= min) {
                if (cur < min) ans.clear();
                min = cur;
                ans.add(rest);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}