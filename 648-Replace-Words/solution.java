class Solution {

    // T: O(m+n)
    // S: O(n)

    class Trie {
        Trie[] children;
        boolean isEnd;
        String data;

        Trie() {
            this.children = new Trie[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.isEmpty()) {
            return sentence;
        }
        // init dict
        Trie trie = new Trie();
        for (String word : dict) {
            Trie node = trie;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.data = word;
            node.isEnd = true;
        }

        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            Trie node = trie;
            for (char c : words[i].toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    break;
                } else {
                    node = node.children[c - 'a'];
                }
                if (node.isEnd) {
                    words[i] = node.data;
                    break;
                }
            }
        }

        return String.join(" ", words);
    }
}