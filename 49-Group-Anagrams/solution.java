class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap();
        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            List<String> group = groupMap.getOrDefault(key, new ArrayList());
            group.add(s);
            groupMap.put(key, group);
        }
        return new ArrayList(groupMap.values());
    }
}