class Solution {
    public int numSimilarGroups(String[] A) {
        Map<String, Integer> idMap = new HashMap();
        for (int i = 0; i < A.length; i++) {
            idMap.put(A[i], i);
        }
        DSU dsu = new DSU(A.length);
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (isSimilar(A[i].toCharArray(), A[j].toCharArray())) {
                    dsu.union(idMap.get(A[i]), idMap.get(A[j]));
                }
            }
        }
        Set<Integer> groups = new HashSet();
        for (String s : A) {
            groups.add(dsu.find(idMap.get(s)));
        }
        return groups.size();
    }

    private boolean isSimilar(char[] A, char[] B) {
        int i = -1, j = - 1;
        for (int k = 0; k < A.length; k++) {
            if (A[k] != B[k]) {
                if (i == -1) {
                    i = k;
                } else if (j == -1) {
                    j = k;
                } else {
                    return false;
                }
            }
        }
        return i >= 0 && j >= 0 && A[i] == B[j] && A[j] == B[i];
    }

    class DSU {
        private int[] parents, rank;

        DSU(int N) {
            this.parents = new int[N];
            this.rank = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] > rank[p_y]) {
                    parents[p_y] = p_x;
                } else if (rank[p_x] < rank[p_y]) {
                    parents[p_x] = p_y;
                } else {
                    parents[p_x] = p_y;
                    rank[p_y]++;
                }
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
}