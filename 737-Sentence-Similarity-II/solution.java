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

        DSU() {
            this.parents = new HashMap();
        }

        String find(String x) {
            if (!parents.containsKey(x)) {
                parents.put(x, x);
            }
            String parent = parents.get(x);
            while (!parent.equals(parents.get(parent))) {
                parent = parents.get(parent);
            }
            // with compression
            String child = x;
            while (!parent.equals(parents.get(child))) {
                String tmp = parents.get(child);
                parents.put(child, parent);
                child = tmp;
            }
            return parent;
        }

        void union(String x, String y) {
            String pa_x = find(x);
            String pa_y = find(y);
            if (!pa_x.equals(pa_y)) {
                parents.put(pa_x, pa_y);
            }
        }
    }
}