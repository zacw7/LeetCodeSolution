class MapSum {

    private Trie trie;

    /** Initialize your data structure here. */
    public MapSum() {
        this.trie = new Trie(0);
    }

    public void insert(String key, int val) {
        if (key == null) {
            return;
        }

        Trie node = trie;
        for (char c : key.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new Trie(0);
            }
            node = node.children[c - 'a'];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        if (prefix == null) {
            return 0;
        }

        int[] sum = {0};
        Trie node = trie;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node = null;
                break;
            }
            node = node.children[c - 'a'];
        }

        sumHelper(node, sum);
        return sum[0];
    }

    private void sumHelper(Trie node, int[] sum) {
        if (node == null) {
            return;
        }

        sum[0] += node.val;
        for (Trie child : node.children) {
            sumHelper(child, sum);
        }
    }

    class Trie {
        int val;
        Trie[] children;

        Trie(int val) {
            this.val = val;
            this.children = new Trie[26];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */