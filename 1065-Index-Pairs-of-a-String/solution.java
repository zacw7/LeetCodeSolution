class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> pairList = new ArrayList();
        for (String w : words) {
            int len = w.length();
            int found = text.indexOf(w);
            while (found >= 0) {
                pairList.add(new int[]{found, found + len - 1});
                found = text.indexOf(w, found + 1);
            }
        }
        int[][] ans = new int[pairList.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = pairList.get(i);
        }
        Arrays.sort(ans, (o1, o2) -> (o1[0] == o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0]);
        return ans;
    }
}