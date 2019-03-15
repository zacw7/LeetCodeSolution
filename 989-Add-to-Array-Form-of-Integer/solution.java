class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new ArrayList();
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--, K /= 10) {
            int digit = A[i] + K % 10 + carry;
            carry = digit / 10;
            ans.add(digit % 10);
        }
        while (K > 0 || carry > 0) {
            int digit = K % 10 + carry;
            carry = digit /10;
            ans.add(digit % 10);
            K /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
}