class Solution {
    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return -1;
        }
        TreeMap<Integer, List<String>> treeMap = new TreeMap(Collections.reverseOrder());
        for (String s : strs) {
            int len = s.length();
            List<String> list = treeMap.getOrDefault(len, new ArrayList());
            list.add(s);
            treeMap.put(len, list);
        }
        for (List<String> list : treeMap.values()) {
            for (int i = 0; i < list.size(); i++) {
                boolean isValid = true;
                String s = list.get(i);
                // check strings with equal length
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    if (isSubsequence(s, list.get(j))) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    continue;
                }
                // check strings with larger length
                for (List<String> strList : treeMap.headMap(s.length()).values()) {
                    for (String str : strList) {
                        if (isSubsequence(s, str)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) {
                        break;
                    }
                }
                if (isValid) {
                    return s.length();
                }
            }
        }
        return -1;
    }

    private boolean isSubsequence(String s1, String s2) {
        int i1 = 0, i2 = 0;
        while (i1 < s1.length()) {
            if (i2 == s2.length()) {
                return false;
            } else if (s1.charAt(i1) == s2.charAt(i2)) {
                i1++;
            }
            i2++;
        }
        return true;
    }
}