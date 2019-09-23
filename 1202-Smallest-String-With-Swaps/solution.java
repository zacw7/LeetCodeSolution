class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU dsu = new DSU(s.length());
        for (List<Integer> p : pairs) {
            int a = p.get(0), b = p.get(1);
            dsu.union(a, b);
            dsu.find(a);
            dsu.find(b);
        }
        Map<Integer, List<Character>> charMap = new HashMap();
        Map<Integer, List<Integer>> indexMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int root = dsu.find(i);
            List<Character> charList = charMap.getOrDefault(root, new ArrayList());
            List<Integer> indexList = indexMap.getOrDefault(root, new ArrayList());
            charList.add(ch);
            indexList.add(i);
            charMap.put(root, charList);
            indexMap.put(root, indexList);
        }
        char[] chs = s.toCharArray();
        for (int key : charMap.keySet()) {
            if (charMap.get(key).size() <= 1) {
                continue;
            }
            List<Character> charList = charMap.get(key);
            List<Integer> indexList = indexMap.get(key);
            Collections.sort(charList);
            for (int i = 0; i < indexList.size(); i++) {
                chs[indexList.get(i)] = charList.get(i);
            }
        }
        return new String(chs);
    }

    class DSU {
        int[] parents, rank;

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
                    parents[p_y] = p_x;
                    rank[p_x]++;
                }
            }
        }

        int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }
}