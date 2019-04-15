class Trie {

    class Node {
        char val;
        boolean isEnd;
        Node[] next;

        Node(char val) {
            this.val = val;
            this.isEnd = false;
            this.next = new Node[26];
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                node.next[ch - 'a'] = new Node(ch);
            }
            node = node.next[ch - 'a'];
        }
        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        Node node = root;
        for (char ch : word.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return false;
            } else {
                node = node.next[ch - 'a'];
            }
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            if (node.next[ch - 'a'] == null) {
                return false;
            } else {
                node = node.next[ch - 'a'];
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */