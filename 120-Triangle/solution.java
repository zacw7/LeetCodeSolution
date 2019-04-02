class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.get(0);
        for (int r = 1; r < triangle.size(); r++) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                if (c == 0) {
                    row.set(c, row.get(c) + prev.get(c));
                } else if (c == row.size() - 1) {
                    row.set(c, row.get(c) + prev.get(c - 1));
                } else {
                    row.set(c, row.get(c) + Math.min(prev.get(c), prev.get(c - 1)));
                }
            }
            prev = row;
        }
        int min = Integer.MAX_VALUE;
        for (int sum : prev) min = Math.min(min, sum);
        return min;
    }
}