class Solution {
    Map<String, Boolean> cache = new HashMap();
    public boolean canWin(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        int index = s.indexOf("++");
        while (index != - 1) {
            if (!canWin(s.substring(0, index) + "--" + s.substring(index + 2, s.length()))) {
                cache.put(s, true);
                break;
            }
            index = s.indexOf("++", index + 1);
        }
        if (index == -1) {
            cache.put(s, false);
        }
        return cache.get(s);
    }
}