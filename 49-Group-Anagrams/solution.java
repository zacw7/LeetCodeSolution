class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> groupMap = new HashMap();
        for (String s : strs) {
            int[] charCount = new int[26];
            for (char c : s.toCharArray()) charCount[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charCount.length; i++) {
                if (charCount[i] > 0) sb.append((char) (i + 'a')).append(charCount[i]);
            }
            String hash = sb.toString();
            List<String> strList = groupMap.getOrDefault(hash, new ArrayList());
            strList.add(s);
            groupMap.put(hash, strList);
        }
        for (List<String> v : groupMap.values()) res.add(v);
        return res;
    }
}