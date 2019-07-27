class Solution {
    public boolean isArmstrong(int N) {
        int k = 0;
        List<Integer> digits = new ArrayList();
        for (int n = N; n > 0; n /= 10) {
            digits.add(n % 10);
        }
        int sum = 0;
        for (int d : digits) {
            sum += (int) Math.pow(d, digits.size());
        }
        return sum == N;
    }
}