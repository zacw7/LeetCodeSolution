class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        DSU dsu = new DSU();
        for (int i = 0; i < A.length(); i++) {
            dsu.union(A.charAt(i) - 'a', B.charAt(i) - 'a');
        }
        int[] min = new int[26];
        Arrays.fill(min, 26);
        for (int i = 0; i < min.length; i++) {
            int p = dsu.find(i);
            min[p] = Math.min(i, min[p]);
        }
        char[] chs = S.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            chs[i] = (char)(min[dsu.find(S.charAt(i) - 'a')] + 'a');
        }
        return new String(chs);
    }

    class DSU{
        int[] parents;
        DSU() {
            this.parents = new int[26];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        int find(int x) {
            int p = parents[x];
            while (p != parents[p]) {
                p = parents[p];
            }
            while (x != parents[x]) {
                int t = parents[x];
                parents[x] = p;
                x = t;
            }
            return p;
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                parents[p_x] = parents[p_y];
            }
        }
    }
}