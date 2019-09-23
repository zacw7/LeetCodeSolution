class Solution {
    public List<List<String>> wordSquares(String[] words) {
        int N = words[0].length();
        TrieNode trie = new TrieNode();
        for (String word : words) {
            TrieNode node = trie;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
            node.val = word;
        }
        List<List<String>> res = new ArrayList();
        List<String> list = new ArrayList();
        Set<String> seen = new HashSet();
        for (String word : words) {
            list.add(word);
            search(list, seen, trie, N, res);
            list.clear();
        }
        return res;
    }

    private void search(List<String> list, Set<String> seen, TrieNode trie, int N, List<List<String>> res) {
        String key = list.toString();
        if (seen.contains(key)) {
            return;
        } else {
            seen.add(key);
        }
        if (list.size() == N) {
            res.add(new ArrayList(list));
            return;
        }
        int i = list.size();
        TrieNode node = trie;
        for (String w : list) {
            char c = w.charAt(i);
            node = node.children[c - 'a'];
            if (node == null) {
                return;
            }
        }
        List<String> candidates = new ArrayList();
        searchString(node, candidates);
        for (String w : candidates) {
            list.add(w);
            search(list, seen, trie, N, res);
            list.remove(list.size() - 1);
        }
    }

    private void searchString(TrieNode node, List<String> candidates) {
        if (node == null) {
            return;
        }
        if (node.isEnd) {
            candidates.add(node.val);
        }
        for (TrieNode child : node.children) {
            searchString(child, candidates);
        }
    }

    class TrieNode {
        boolean isEnd;
        String val;
        TrieNode[] children;

        TrieNode() {
            this.isEnd = false;
            this.children = new TrieNode[26];
        }
    }
}