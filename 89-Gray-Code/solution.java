class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList();
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            List<Integer> tmp = new ArrayList(ans);
            for (int k = 0; k < tmp.size(); k++) tmp.set(k, tmp.get(k) | mask);
            Collections.reverse(tmp);
            ans.addAll(tmp);
        }
        return ans;
    }
}