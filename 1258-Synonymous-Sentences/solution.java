class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> res = new ArrayList();
        if (text == null || text.length() == 0) {
            res.add(text);
            return res;
        }
        DSU dsu = new DSU();
        for (List<String> s : synonyms) {
            dsu.union(s.get(0), s.get(1));
        }
        Map<String, Set<String>> groups = new HashMap();
        for (String s : dsu.parents.keySet()) {
            String r = dsu.find(s);
            Set<String> g = groups.getOrDefault(r, new HashSet());
            g.add(s);
            groups.put(r, g);
        }
        String[] words = text.split(" ");
        dfs(words, 0, res, dsu, groups);
        Collections.sort(res);
        return res;
    }

    private void dfs(String[] words, int idx, List<String> res, DSU dsu, Map<String, Set<String>> groups) {
        if (idx >= words.length) {
            return;
        }
        String prefix = "";
        if (idx == 0) {
            res.add("");
        } else {
            prefix = " ";
        }
        List<String> tmp = new ArrayList();
        if (dsu.parents.containsKey(words[idx])) {
            for (String s : res) {
                for (String syn : groups.get(dsu.find(words[idx]))) {
                    tmp.add(s + prefix + syn);
                }
            }
        } else {
            for (String s : res) {
                tmp.add(s + prefix + words[idx]);
            }
        }
        res.clear();
        res.addAll(tmp);
        dfs(words, idx + 1, res, dsu, groups);
    }

    class DSU {
        Map<String, String> parents;
        private Map<String, Integer> rank;

        DSU() {
            this.parents = new HashMap();
            this.rank = new HashMap();
        }

        void union(String x, String y) {
            String p_x = find(x);
            String p_y = find(y);
            if (!p_x.equals(p_y)) {
                int r_x = rank.getOrDefault(p_x, 0);
                int r_y = rank.getOrDefault(p_y, 0);
                if (r_x > r_y) {
                    parents.put(p_y, p_x);
                } else if (r_x < r_y) {
                    parents.put(p_x, p_y);
                } else {
                    parents.put(p_x, p_y);
                    rank.put(p_y, r_y + 1);
                }
            }
        }

        String find(String x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
                return x;
            } else {
                String p = parents.get(x);
                if (!x.equals(p)) {
                    p = find(p);
                    parents.put(x, p);
                }
                return p;
            }
        }
    }
}