class Solution {

    private int R, C, total;
    private Map<Integer, Integer> map;

    public Solution(int n_rows, int n_cols) {
        this.R = n_rows;
        this.C = n_cols;
        this.total = R * C;
        this.map = new HashMap();
    }

    public int[] flip() {
        int i = (int)(Math.random() * total--);
        int x = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(total, total));
        return new int[]{x / C, x % C};
    }

    public void reset() {
        map.clear();
        total = R * C;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */