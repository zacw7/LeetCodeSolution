class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        int N = str1.length();
        Map<Character, Character> transMap = new HashMap();
        for (int i = 0; i < N; i++) {
            char source = str1.charAt(i), target = str2.charAt(i);
            if (transMap.containsKey(source)) {
                if (target != transMap.get(source)) {
                    return false;
                }
            } else {
                transMap.put(source, target);
            }
        }
        return transMap.size() < 26 || new HashSet(transMap.values()).size() < 26;
    }
}