class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (count1 == 0 && candidate2 != n) {
                candidate1 = n;
                count1++;
            } else if (candidate1 == n) {
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else if (candidate2 == n) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            }
        }

        List<Integer> ans = new ArrayList();
        if (count1 > nums.length / 3) {
            ans.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            ans.add(candidate2);
        }
        return ans;
    }
}