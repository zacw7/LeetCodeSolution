class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        Map<String, List<Integer>> letterMap = new HashMap();
        for (int i = logs.length - 1, digitIndex = logs.length - 1; i >= 0; i--) {
            String s = logs[i];
            if (s.charAt(s.length() - 1) >= 1 && s.charAt(s.length() - 1) <= '9') {
                ans[digitIndex--] = s;
            } else {
                String log = s.split(" ", 2)[1];
                List<Integer> indexes = letterMap.getOrDefault(log, new ArrayList());
                indexes.add(i);
                letterMap.put(log, indexes);
            }
        }
        List<String> logList = new ArrayList(letterMap.keySet());
        Collections.sort(logList);
        int index = 0;
        for (String log : logList) {
            List<Integer> indexes = letterMap.get(log);
            for (int i : indexes) {
                ans[index++] = logs[i];
            }
        }
        return ans;
    }
}