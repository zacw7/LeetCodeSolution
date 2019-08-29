class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList();
        if (words == null || words.length == 0 || s == null || s.length() == 0) {
            return res;
        }
        Map<String, Integer> expect = new HashMap();
        for (String w : words) {
            expect.put(w, expect.getOrDefault(w, 0) + 1);
        }
        Map<String, Integer> seen = new HashMap();
        int len = words[0].length();
        for (int i = 0; i < len; i++) {
            int lo = i, hi = i;
            while (hi + len <= s.length()) {
                String cur = s.substring(hi, hi + len);
                hi += len;
                if (expect.containsKey(cur)) {
                    seen.put(cur, seen.getOrDefault(cur, 0) + 1);
                    while (seen.get(cur) > expect.get(cur)) {
                        String tmp = s.substring(lo, lo + len);
                        seen.put(tmp, seen.get(tmp) - 1);
                        lo += len;
                    }
                } else {
                    lo = hi;
                    seen.clear();
                }
                if (isValid(expect, seen)) {
                    res.add(lo);
                    String tmp = s.substring(lo, lo + len);
                    seen.put(tmp, seen.get(tmp) - 1);
                    lo += len;
                }
            }
            seen.clear();
        }
        return res;
    }

    private boolean isValid(Map<String, Integer> expect, Map<String, Integer> seen) {
        if (expect.size() != seen.size()) {
            return false;
        }
        for (Map.Entry<String, Integer> entry : expect.entrySet()) {
            if (entry.getValue() != seen.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }
}