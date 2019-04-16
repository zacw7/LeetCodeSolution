class WordDictionary {

    class Node {
        char data;
        Node[] children;
        boolean isEnd;

        Node(char data) {
            this.data = data;
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Node(c);
            }
            node = node.children[c - 'a'];

        }
        node.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(Node node, String word, int index) {
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = index; i < word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (Node next : node.children) {
                    if (next == null) {
                        continue;
                    }
                    if (searchHelper(next, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else if (node.children[word.charAt(i) - 'a'] != null) {
                node = node.children[word.charAt(i) - 'a'];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */