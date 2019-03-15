class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> idxMap = new HashMap();
        for (int i = 0; i < list1.length; i++) {
            idxMap.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> ans = new ArrayList();
        for (int j = 0; j < list2.length; j++) {
            if (idxMap.keySet().contains(list2[j])) {
                int cur = idxMap.get(list2[j]) + j;
                if (cur <= min) {
                    if (cur < min) {
                        min = cur;
                        ans.clear();
                    }
                    ans.add(list2[j]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}