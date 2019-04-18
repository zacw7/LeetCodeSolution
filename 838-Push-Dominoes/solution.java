class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() <= 1) {
            return dominoes;
        }
        int prev = -1;
        char[] chars = dominoes.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                continue;
            } else if (chars[i] == 'L') {
                if (prev >= 0 && chars[prev] == 'R') {
                    for (int left = prev + 1, right = i - 1; left < right; left++, right--) {
                        chars[left] = 'R';
                        chars[right] = 'L';
                    }
                } else {
                    for (int j = i - 1; j > prev; j--) {
                        chars[j] = 'L';
                    }
                }
                prev = i;
            } else {
                if (prev >= 0 && chars[prev] == 'R') {
                    for (int j = prev + 1; j < i; j++) {
                        chars[j] = 'R';
                    }
                }
                prev = i;
            }
        }

        if (prev >= 0 && chars[prev] == 'R') {
            for (int j = prev + 1; j < chars.length; j++) {
                chars[j] = 'R';
            }
        }

        return new String(chars);
    }
}