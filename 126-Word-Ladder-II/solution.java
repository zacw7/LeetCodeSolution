class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() == 0) return 0;
        List<String> cur = new ArrayList();
        Set<String> seen = new HashSet();
        seen.add(beginWord);
        cur.add(beginWord);
        int res = bfs(cur, endWord, wordList, seen);
        return (res == 0) ? 0 : res;
    }

    private int bfs(List<String> cur, String target, List<String> dict, Set<String> seen) {
        System.out.println(cur);
        if (cur.isEmpty()) return 0;
        List<String> tmp = new ArrayList();
        for (String word : cur) {
            if (word.equals(target)) return 1;
            for (String d : dict) {
                if (!seen.contains(d) && canTransformed(word, d)) {
                    tmp.add(d);
                    seen.add(d);
                }
            }
        }
        cur = tmp;
        int res = bfs(cur, target, dict, seen);
        return (res == 0) ? 0 : res + 1;
    }

    private boolean canTransformed(String source, String target) {
        boolean res = false;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                if (res) return false;
                else res = true;
            }
        }
        return res;
    }
}