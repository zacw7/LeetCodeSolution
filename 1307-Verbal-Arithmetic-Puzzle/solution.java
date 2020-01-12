class Solution {
    public boolean isSolvable(String[] words, String result) {
        return isSolvable(words, result, 0, 0, new HashMap(), new boolean[10]);
    }

    private boolean isSolvable(String[] words, String result, int i, int carry, Map<Character, Integer> map, boolean[] assigned) {
        if (i >= result.length()) {
            if (carry > 0) {
                return false;
            }
            if (map.get(result.charAt(0)) == 0) {
                return false;
            }
            for (String w : words) {
                if (i < w.length() && map.get(w.charAt(0)) == 0) {
                    return false;
                }
            }
            return true;
        }
        int sum = 0;
        for (String w : words) {
            if (i >= w.length()) {
                continue;
            }
            int idx = w.length() - i - 1;
            char c = w.charAt(idx);
            if (map.containsKey(c)) {
                if (idx == 0 && map.get(c) == 0) {
                    return false;
                }
                sum += map.get(c);
            } else {
                // try
                for (int n = 0; n < 10; n++) {
                    if (n == 0 && idx == 0) {
                        continue;
                    }
                    if (assigned[n]) {
                        continue;
                    }
                    assigned[n] = true;
                    map.put(c, n);
                    if (isSolvable(words, result, i, carry, map, assigned)) {
                        return true;
                    }
                    map.remove(c);
                    assigned[n] = false;
                }
                return false;
            }
        }
        sum += carry;
        int digit = sum % 10;
        char cr = result.charAt(result.length() - i - 1);
        if (map.containsKey(cr)) {
            int num = map.get(cr);
            return digit == map.get(cr) && isSolvable(words, result, i + 1, sum / 10, map, assigned);
        } else {
            if (assigned[digit]) {
                return false;
            } else {
                assigned[digit] = true;
                map.put(cr, digit);
                if (isSolvable(words, result, i + 1, sum / 10, map, assigned)) {
                    return true;
                }
                map.remove(cr);
                assigned[digit] = false;
            }
        }
        return false;
    }
}