class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int evenIndex = 0, oddIndex = 1;
        for (int num : A) {
            if (num % 2 == 0) {
                ans[evenIndex] = num;
                evenIndex += 2;
            } else {
                ans[oddIndex] = num;
                oddIndex += 2;
            }
        }
        return ans;
    }
}