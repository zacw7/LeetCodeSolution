class MagicDictionary {

    private Trie trie;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        this.trie = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            Trie node = trie;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Trie node = trie;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            for (Trie n : node.children) {
                if (n != node.children[ch - 'a'] && searchHelper(word, i + 1, n)) {
                    return true;
                }
            }
            if (node.children[ch - 'a'] == null) {
                break;
            } else {
                node = node.children[ch - 'a'];
            }
        }
        return false;
    }

    private boolean searchHelper(String word, int index, Trie trie) {
        if (trie == null) {
            return false;
        }
        if (index == word.length()) {
            return trie.isEnd;
        }
        Trie node = trie;
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                return false;
            } else {
                node = node.children[ch - 'a'];
            }
        }
        return node.isEnd;
    }

    class Trie {
        boolean isEnd;
        Trie[] children;

        Trie() {
            this.isEnd = false;
            this.children = new Trie[26];
        }
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */