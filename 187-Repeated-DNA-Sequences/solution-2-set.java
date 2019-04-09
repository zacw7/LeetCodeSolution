class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet(), ignored = new HashSet();
        List<String> ans = new ArrayList();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            if (ignored.contains(str)) continue;
            if (seen.contains(str)) {
                ans.add(str);
                ignored.add(str);
            } else seen.add(str);
        }
        return ans;
    }
}