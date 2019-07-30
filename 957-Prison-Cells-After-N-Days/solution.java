class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int bin = 0;
        for (int c : cells) {
            bin <<= 1;
            bin |= c;
        }
        int mask = 126;
        Map<Integer, Integer> indexToDay = new HashMap();
        Set<Integer> seen = new HashSet();
        int n = 0;
        while (n < N) {
            bin = (~((bin << 1) ^ (bin >> 1))) & mask;
            if (seen.contains(bin)) {
                break;
            } else {
                seen.add(bin);
                indexToDay.put(n, bin);
            }
            n++;
        }
        if (n < N) {
            bin = indexToDay.get((N - 1) % n);
        }
        for (int i = 0; i < cells.length; i++) {
            cells[i] = (bin >> (7 - i)) & 1;
        }
        return cells;
    }
}