class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode trie = new TrieNode();
        for (String p : products) {
            TrieNode node = trie;
            for (char c : p.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.val = p;
            node.count++;
        }

        List<List<String>> res = new ArrayList();
        TrieNode node = trie;
        for (char c : searchWord.toCharArray()) {
            if (node != null) {
                node = node.children[c - 'a'];
            }
            List<String> list = new ArrayList();
            searchHelper(node, list);
            res.add(list);
        }
        return res;
    }

    private void searchHelper(TrieNode node, List<String> list) {
        if (node == null || list.size() >= 3) {
            return;
        }

        if (node.count > 0) {
            for (int i = 0; i < node.count && list.size() < 3; i++) {
                list.add(node.val);
            }
        }

        for (int i = 0; i < 26; i++) {
            searchHelper(node.children[i], list);
        }
    }

    class TrieNode {
        String val;
        int count;
        TrieNode[] children;

        TrieNode() {
            this.val = null;
            this.count = 0;
            this.children = new TrieNode[26];
        }
    }
}