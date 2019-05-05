class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList(n);
        for (int i = 1; i <= 9; i++) {
            orderHelper(i, n, ans);
        }
        return ans;
    }

    private void orderHelper(int num, int upperBound, List<Integer> ans) {
        if (num > upperBound) {
            return;
        }
        ans.add(num);
        num *= 10;
        for (int i = 0; i <= 9; i++) {
            if (num + i > upperBound) {
                return;
            }
            orderHelper(num + i, upperBound, ans);
        }
    }
}