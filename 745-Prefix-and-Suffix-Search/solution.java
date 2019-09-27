class WordFilter {

    TrieNode prefixTrie, suffixTrie;
    Map<String, Integer> cache;

    public WordFilter(String[] words) {
        this.cache = new HashMap();
        this.prefixTrie = new TrieNode();
        this.suffixTrie = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            prefixTrie.weights.add(i);
            suffixTrie.weights.add(i);
            TrieNode node = prefixTrie;
            for (char c : words[i].toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.weights.add(i);
            }
            node.isEnd = true;
            node = suffixTrie;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                char c = words[i].charAt(j);
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
                node.weights.add(i);
            }
            node.isEnd = true;
        }
    }

    public int f(String prefix, String suffix) {
        String key = prefix + "/" + suffix;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int maxWeight = -1;
        TrieNode prefixNode = prefixTrie;
        TrieNode suffixNode = suffixTrie;
        for (char c : prefix.toCharArray()) {
            if (prefixNode.children[c - 'a'] == null) {
                cache.put(key, maxWeight);
                return maxWeight;
            }
            prefixNode = prefixNode.children[c - 'a'];
        }
        for (int i = suffix.length() - 1; i >= 0; i--) {
            char c = suffix.charAt(i);
            if (suffixNode.children[c - 'a'] == null) {
                cache.put(key, maxWeight);
                return maxWeight;
            }
            suffixNode = suffixNode.children[c - 'a'];
        }
        for (int w : prefixNode.weights) {
            if (suffixNode.weights.contains(w)) {
                maxWeight = Math.max(w, maxWeight);
            }
        }
        cache.put(key, maxWeight);
        return maxWeight;
    }

    class TrieNode {
        boolean isEnd;
        Set<Integer> weights;
        TrieNode[] children;

        TrieNode() {
            this.isEnd = false;
            this.weights = new HashSet();
            this.children = new TrieNode[26];
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */