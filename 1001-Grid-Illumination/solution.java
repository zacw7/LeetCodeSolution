class Solution {
    // Hash Table
    // TC: O(NM)
    // SC: O(N)
    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
        int[] ans = new int[queries.length];
        if (queries.length == 0 || lamps.length == 0) {
            return ans;
        }
        Set<Long> lampSet = new HashSet();
        Map<Integer, Integer> rowLamps = new HashMap();
        Map<Integer, Integer> colLamps = new HashMap();
        Map<Integer, Integer> lDigLamps = new HashMap();
        Map<Integer, Integer> rDigLamps = new HashMap();
        for (int[] lamp : lamps) {
            lampSet.add((long) lamp[0] * N + lamp[1]);
            rowLamps.put(lamp[0], rowLamps.getOrDefault(lamp[0], 0) + 1);
            colLamps.put(lamp[1], colLamps.getOrDefault(lamp[1], 0) + 1);
            lDigLamps.put(lamp[0] - lamp[1], lDigLamps.getOrDefault(lamp[0] - lamp[1], 0) + 1);
            rDigLamps.put(lamp[0] + lamp[1], rDigLamps.getOrDefault(lamp[0] + lamp[1], 0) + 1);
        }

        int[] d = {-1, 0, 1};
        for (int i = 0; i < queries.length; i++) {
            int x0 = queries[i][0], y0 = queries[i][1];
            // check cell(x, y)
            if (rowLamps.containsKey(x0) || colLamps.containsKey(y0)
                    || lDigLamps.containsKey(x0 - y0) || rDigLamps.containsKey(x0 + y0)) {
                ans[i] = 1;
            }
            // turn off lamp
            for (int ix = 0; ix < d.length; ix++) {
                for (int iy = 0; iy < d.length; iy++) {
                    int x = x0 + d[ix], y = y0 + d[iy];
                    long key = x * N + y;
                    if (x >= 0 && y >= 0 && x < N && y < N && lampSet.contains(key)) {
                        lampSet.remove(key);
                        rowLamps.put(x, rowLamps.get(x) - 1);
                        colLamps.put(y, colLamps.get(y) - 1);
                        lDigLamps.put(x - y, lDigLamps.get(x - y) - 1);
                        rDigLamps.put(x + y, rDigLamps.get(x + y) - 1);
                        if (rowLamps.get(x) == 0) {
                            rowLamps.remove(x);
                        }
                        if (colLamps.get(y) == 0) {
                            colLamps.remove(y);
                        }
                        if (lDigLamps.get(x - y) == 0) {
                            lDigLamps.remove(x - y);
                        }
                        if (rDigLamps.get(x + y) == 0) {
                            rDigLamps.remove(x + y);
                        }
                    }
                }
            }
            if (lampSet.isEmpty()) {
                break;
            }
        }

        return ans;
    }
}