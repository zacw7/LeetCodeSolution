class Solution {
    public int findMinStep(String board, String hand) {
        int[] ballCount = new int[26];
        for (char c : hand.toCharArray()) {
            ballCount[c - 'A']++;
        }
        int step = zumaHelper(board, ballCount);
        return step > MAX_STEP ? -1 : step;
    }

    private int MAX_STEP = 6;
    private Map<String, Integer> cache = new HashMap();
    private int zumaHelper(String board, int[] ballCount) {
        if (board.length() == 0) {
            return 0;
        }
        String key = board + Arrays.toString(ballCount);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int l = 0, r = 0;
        while (r <= board.length()) {
            if (r == board.length() || board.charAt(l) != board.charAt(r)) {
                if (r - l >= 3) {
                    break;
                }
                l = r;
            }
            r++;
        }
        int minStep = MAX_STEP + 1;
        if (r - l >= 3) {
            minStep = zumaHelper(board.substring(0, l) + board.substring(r), ballCount);
        } else {
            int i = 0;
            while (i < board.length()) {
                char c = board.charAt(i);
                if (ballCount[c - 'A'] > 0 && (i == 0 || c != board.charAt(i - 1))) {
                    ballCount[c - 'A']--;
                    int step = zumaHelper(board.substring(0, i) + String.valueOf(c) + board.substring(i), ballCount);
                    if (step != -1) {
                        minStep = Math.min(step + 1, minStep);
                    }
                    ballCount[c - 'A']++;
                }
                i++;
            }
        }
        cache.put(key, minStep);
        return minStep;
    }
}