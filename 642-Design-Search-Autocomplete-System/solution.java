class AutocompleteSystem {

    private Trie root, cur;
    private StringBuilder sb;
    private Map<String, Integer> hotMap;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.root = new Trie(0);
        this.cur = root;
        this.sb = new StringBuilder();
        this.hotMap = new HashMap();
        for (int i = 0; i < sentences.length; i++) {
            if (i >= times.length || times[i] == 0) {
                continue;
            }
            Trie node = root;
            StringBuilder tmp = new StringBuilder();
            for (char c : sentences[i].toCharArray()) {
                tmp.append(c);
                int index = (c == ' ') ? 26 : c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie(0);
                }
                node = node.children[index];
            }
            node.hotDegree += times[i];
            hotMap.put(tmp.toString(), node.hotDegree);
        }
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList();
        if (c == '#') {
            cur.hotDegree++;
            hotMap.put(sb.toString(), cur.hotDegree);
            cur = root;
            sb.setLength(0);
        } else {
            sb.append(c);
            int index = (c == ' ') ? 26 : c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie(0);
            }
            cur = cur.children[index];
            completeHelper(cur, sb, res);
            Collections.sort(res, (o1, o2) -> (hotMap.get(o1) == (hotMap.get(o2))) ? o1.compareTo(o2) : (hotMap.get(o2) - (hotMap.get(o1))));
            if (res.size() > 3) {
                res = res.subList(0, 3);
            }
        }
        return res;
    }

    private void completeHelper(Trie node, StringBuilder sb, List<String> res) {
        if (node.hotDegree > 0) {
            res.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                sb.append((char)(i + 'a'));
                completeHelper(node.children[i], sb, res);
                sb.setLength(sb.length() - 1);
            }
        }
        if (node.children[26] != null) {
            sb.append((char)(' '));
            completeHelper(node.children[26], sb, res);
            sb.setLength(sb.length() - 1);
        }
    }

    class Trie {
        int hotDegree;
        String value;
        Trie[] children;

        Trie(int hotDegree) {
            this.hotDegree = hotDegree;
            this.children = new Trie[27]; // 0~25: 'a'~'z', 26: ' '
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */