class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new ArrayList();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            List<Integer> tmp = new ArrayList(ans);
            for (int k = 0; k < tmp.size(); k++) tmp.set(k, tmp.get(k) | mask);
            Collections.reverse(tmp);
            ans.addAll(tmp);
        }
        int count = 0;
        for (int x : ans) {
            if (x != start) {
                count++;
            } else {
                break;
            }
        }
        if (count == 0) {
            return ans;
        }
        List<Integer> res = new ArrayList();
        int N = ans.size();
        for (int i = count; i < N + count; i++) {
            res.add(ans.get(i % N));
        }
        return res;
    }
}