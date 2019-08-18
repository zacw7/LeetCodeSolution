class Solution {
    public String lastSubstring(String s) {
        char maxChar = findMaxChar(s);
        char[] chs = s.toCharArray();
        int maxLen = 0;
        Map<Integer, Integer> cntMap = new HashMap();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == maxChar) {
                int len = cntMap.getOrDefault(i - 1, 0) + 1;
                cntMap.put(i, len);
                maxLen = Math.max(len, maxLen);
            }
        }
        Set<Integer> idxs = new HashSet();
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == maxLen) {
                idxs.add(entry.getKey());
            }
        }
        int len = 1;
        while (idxs.size() > 1) {
            char max = (char) 0;
            for (int i : idxs) {
                if (i + len < chs.length && chs[i + len] > max) {
                    max = chs[i + len];
                }
            }
            if (max == (char) 0) {
                break;
            }
            Set<Integer> tmp = new HashSet();
            for (int i : idxs) {
                if (i + len < chs.length && chs[i + len] == max) {
                    tmp.add(i);
                }
            }
            idxs = tmp;
            len++;
        }
        for (int i : idxs) {
            return s.substring(i - maxLen + 1);
        }
        return "";
    }

    private char findMaxChar(String s) {
        char max = (char) 0;
        for (char c : s.toCharArray()) {
            if (c > max) {
                max = c;
            }
        }
        return max;
    }
}