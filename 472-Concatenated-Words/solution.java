class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // init trie
        Trie trie = new Trie();
        for (String w : words) {
            Trie node = trie;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        List<String> ans = new ArrayList();
        for (String w : words) {
            if (isConcatenated(w, trie, 0)) {
                ans.add(w);
            }
        }
        return ans;
    }

    private boolean isConcatenated(String word, Trie trie, int start) {
        if (start == word.length() && start > 0) {
            return true;
        }
        Trie node = trie;
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return false;
            } else if (node.isEnd && isConcatenated(word, trie, i + 1)) {
                if (start > 0 || i + 1 < word.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    class Trie {
        private boolean isEnd;
        private Trie[] children;

        Trie() {
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }
}