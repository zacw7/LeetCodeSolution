class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList();
        for (int i = 1; i <= 9; i++) {
            dfs(i, res, low, high);
        }
        Collections.sort(res);
        return res;
    }

    private void dfs(int num, List<Integer> res, int low, int high) {
        if (num > high) {
            return;
        }
        if (num >= low) {
            res.add(num);
        }
        int d = num % 10;
        if (d == 9) {
            return;
        }
        num *= 10;
        num += (d + 1);
        dfs(num, res, low, high);
    }
}