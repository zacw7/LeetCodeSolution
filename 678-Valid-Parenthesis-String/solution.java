class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s.toCharArray(), 0, 0);
    }

    private Map<Integer, Boolean> cache = new HashMap();

    private boolean checkValidString(char[] chs, int i, int unmatch) {
        if (i == chs.length) {
            return unmatch == 0;
        }
        if (unmatch < 0) {
            return false;
        }
        int key = i * 100 + unmatch;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean res = false;
        if (chs[i] == '(') {
            res = checkValidString(chs, i + 1, unmatch + 1);
        } else if (chs[i] == ')') {
            res = checkValidString(chs, i + 1, unmatch - 1);
        } else if (chs[i] == '*') {
            res = checkValidString(chs, i + 1, unmatch)
                    || checkValidString(chs, i + 1, unmatch + 1)
                    || checkValidString(chs, i + 1, unmatch - 1);
        }
        cache.put(key, res);
        return res;
    }
}