class Solution {
    // Disjoint Set Union
    // T: O(n+p)
    // S: O(p)
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }
        DSU dsu = new DSU();
        for (String[] pair : pairs) {
            dsu.union(pair[0], pair[1]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!dsu.find(words1[i]).equals(dsu.find(words2[i]))) {
                return false;
            }
        }
        return true;
    }

    class DSU {
        Map<String, String> parents;
        Map<String, Integer> rank;

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
            String p = parents.getOrDefault(x, x);
            if (!x.equals(p)) {
                p = find(p);
                parents.put(x, p);
            }
            return p;
        }
    }
}