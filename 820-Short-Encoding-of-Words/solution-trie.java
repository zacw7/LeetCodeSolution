class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        TrieNode trie = new TrieNode();
        for (String w : words) {
            TrieNode node = trie;
            for (int i = w.length() - 1; i >= 0; i--) {
                char c = w.charAt(i);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                    node.childrenCount++;
                }
                node = node.children[c - 'a'];
            }
        }
        int[] ans = {0};
        traverseTrie(trie, 0, ans);
        return ans[0];
    }

    private void traverseTrie(TrieNode node, int len, int[] ans) {
        if (node.childrenCount == 0) {
            ans[0] += len + 1;
        } else {
            for (TrieNode child : node.children) {
                if (child != null) {
                    traverseTrie(child, len + 1, ans);
                }
            }
        }
    }

    class TrieNode {
        int childrenCount;
        TrieNode[] children;

        TrieNode() {
            this.childrenCount = 0;
            this.children = new TrieNode[26];
        }
    }
}