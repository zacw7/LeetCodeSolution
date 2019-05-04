class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList();
        if (n == 0) {
            return ans;
        }
        for (int i = 2, root = (int) Math.sqrt(n); i <= root; i++) {
            if (n % i == 0) {
                for (List<Integer> item : getFactors(n / i, i)) {
                    item.add(i);
                    ans.add(item);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> getFactors(int n, int minimal) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> self = new ArrayList();
        self.add(n);
        ans.add(self);
        for (int i = minimal, root = (int) Math.sqrt(n); i <= root; i++) {
            if (n % i == 0) {
                for (List<Integer> item : getFactors(n / i, i)) {
                    item.add(i);
                    ans.add(item);
                }
            }
        }
        return ans;
    }
}