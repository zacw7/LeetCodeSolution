class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> seqCount = new HashMap();
        for (int i = 10; i <= s.length(); i++) {
            String str = s.substring(i - 10, i);
            seqCount.put(str, seqCount.getOrDefault(str, 0) + 1);
        }
        List<String> ans = new ArrayList();
        for (Map.Entry<String, Integer> entry : seqCount.entrySet()) {
            if (entry.getValue() > 1) ans.add(entry.getKey());
        }
        return ans;
    }
}