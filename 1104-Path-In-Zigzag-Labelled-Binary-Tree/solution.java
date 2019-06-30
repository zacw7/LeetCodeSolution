class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList();
        int n = 1;
        while (label > 0) {
            ans.add(label);
            label /= 2;
            n *= 2;
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i % 2 > 0) {
                ans.set(i, n / 2 + n - 1 - ans.get(i));
            }
            n /= 2;
        }
        Collections.reverse(ans);
        return ans;
    }
}