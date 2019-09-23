class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList();
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff <= minDiff) {
                if (diff < minDiff) {
                    minDiff = diff;
                    res.clear();
                }
                List<Integer> cur = new ArrayList();
                cur.add(arr[i - 1]);
                cur.add(arr[i]);
                res.add(cur);
            }
        }
        return res;
    }
}