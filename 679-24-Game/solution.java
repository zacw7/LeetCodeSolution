class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList();
        for (int n : nums) {
            list.add(n * 1.0);
        }
        return judgePoint24(list);
    }

    private boolean judgePoint24(List<Double> nums) {
        if (nums.isEmpty()) {
            return false;
        }
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i == j) {
                    continue;
                }
                double n1 = nums.get(i), n2 = nums.get(j);
                List<Double> cur = new ArrayList();
                for (int t = 0; t < nums.size(); t++) {
                    if (t != i && t != j) {
                        cur.add(nums.get(t));
                    }
                }
                List<Double> tmp = new ArrayList(cur);
                tmp.add(n1 + n2);
                if (judgePoint24(tmp)) {
                    return true;
                }
                tmp = new ArrayList(cur);
                tmp.add(n1 - n2);
                if (judgePoint24(tmp)) {
                    return true;
                }
                tmp = new ArrayList(cur);
                tmp.add(n1 * n2);
                if (judgePoint24(tmp)) {
                    return true;
                }
                if (n2 != 0) {
                    tmp = new ArrayList(cur);
                    tmp.add(n1 / n2);
                    if (judgePoint24(tmp)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}