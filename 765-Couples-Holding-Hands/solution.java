class Solution {
    public int minSwapsCouples(int[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int couple = row[i] / 2;
            if (couple != row[i + 1] / 2) {
                int j = i + 2;
                while (j < row.length && row[j] / 2 != couple) {
                    j++;
                }
                swap(row, i + 1, j);
                count++;
            }
        }
        return count;
    }

    private void swap(int[] row, int i, int j) {
        int tmp = row[i];
        row[i] = row[j];
        row[j] = tmp;
    }
}