class Solution {
    public String getPermutation(int n, int k) {
        List<Character> digits = new ArrayList();
        int p = 1;
        for (int i = 1; i <= n; i++) {
            digits.add((char) (i + '0'));
            p *= i;
        }
        StringBuilder sb = new StringBuilder();
        k -= 1;
        for (int i = n; i > 1 ; i--) {
            p /= i;
            sb.append(digits.get(k / p));
            digits.remove(k / p);
            k %= p;
        }
        return sb.append(digits.get(0)).toString();
    }
}