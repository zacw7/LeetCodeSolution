class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Trie trie = new Trie();
        for (String w : words) {
            Trie node = trie;
            for (char c : w.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Trie();
                }
                node = node.children[c - 'a'];
            }
            node.count++;
        }
        int count = 0;
        List<Trie> list = new ArrayList();
        list.add(trie);
        for (char c : S.toCharArray()) {
            if (list.isEmpty()) {
                break;
            }
            List<Trie> tmp = new ArrayList();
            for (Trie node : list) {
                tmp.add(node);
                if (node.children[c - 'a'] != null) {
                    tmp.add(node.children[c - 'a']);
                    node.children[c - 'a'] = null;
                }
            }
            list.clear();
            for (Trie node : tmp) {
                count += node.count;
                node.count = 0;
                for (Trie child : node.children) {
                    if (child != null) {
                        list.add(node);
                        break;
                    }
                }
            }
        }
        return count;
    }

    class Trie {
        int count;
        Trie[] children;

        Trie() {
            this.count = 0;
            this.children = new Trie[26];
        }
    }
}