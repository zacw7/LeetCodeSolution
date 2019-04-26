class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groupMap = new HashMap();

        for (String s : strings) {
            String shifted = shiftHelper(s);
            List<String> group = groupMap.getOrDefault(shifted, new ArrayList());
            group.add(s);
            groupMap.put(shifted, group);
        }

        return new ArrayList(groupMap.values());
    }

    private String shiftHelper(String s) {
        char[] chs = s.toCharArray();
        int delta = chs[0] - 'a';
        if (delta == 0) {
            return s;
        } else {
            for (int i = 0; i < chs.length; i++) {
                chs[i] -= delta;
                if (chs[i] < 'a') {
                    chs[i] += 26;
                }
            }
        }
        return new String(chs);
    }
}