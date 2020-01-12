class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i += 2) {
            int n = nums[i + 1], c = nums[i];
            while (c-- > 0) {
                list.add(n);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}