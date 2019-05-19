class Solution {
    int count = 0;
    public int countArrangement(int N) {
        if (N <= 0) {
            return 0;
        }
        boolean[] used = new boolean[N];
        countHelper(used, 1, N);
        return count;
    }

    private void countHelper(boolean[] used, int position, int N) {
        if (position > N) {
            count++;
            return;
        }
        for (int num = 1; num <= N; num++) {
            if (used[num - 1]) {
                continue;
            }
            if (position % num == 0 || num % position == 0) {
                used[num - 1] = true;
                countHelper(used, position + 1, N);
                used[num - 1] = false;
            }
        }
    }
}