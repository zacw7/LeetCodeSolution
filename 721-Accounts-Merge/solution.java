class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> nameMap = new HashMap();
        DSU dsu = new DSU();
        for (List<String> acct : accounts) {
            String name = acct.get(0);
            for (int i = 1; i < acct.size(); i++) {
                nameMap.put(acct.get(i), name);
                if (i > 1) {
                    dsu.union(acct.get(i), acct.get(i - 1));
                }
            }
        }
        Map<String, List<String>> accountMap = new HashMap();
        for (String email : nameMap.keySet()) {
            String root = dsu.find(email);
            List<String> list = accountMap.getOrDefault(root, new ArrayList());
            list.add(email);
            accountMap.put(root, list);
        }
        List<List<String>> ans = new ArrayList(accountMap.values());
        for (List<String> acct : ans) {
            Collections.sort(acct);
            acct.add(0, nameMap.get(acct.get(0)));
        }
        return ans;
    }

    class DSU {
        private Map<String, String> parents;
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
            String p = parents.getOrDefault(x, x);
            if (!x.equals(p)) {
                p = find(p);
                parents.put(x, p);
            }
            return p;
        }
    }
}