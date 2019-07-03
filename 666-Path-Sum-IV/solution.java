class Solution {
    public int pathSum(int[] nums) {
        int[] weight = {0, 1, 3, 7};
        int[] vals = new int[16];
        Arrays.fill(vals, -1);
        for (int n : nums) {
            int level = n / 100 - 1;
            int pos = weight[level] + (n % 100) / 10;
            int val = n % 10;
            vals[pos] = val;
        }
        int sum = 0;
        for (int i = 1; i < 16; i++) {
            if (vals[i] != -1 && (i > 7 || (vals[i * 2] == -1 && vals[i * 2 + 1] == -1))) {
                // leaf
                sum += vals[i];
                int p = i / 2;
                while (p > 0) {
                    sum += vals[p];
                    p /= 2;
                }
            }
        }
        return sum;
    }
}