class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 3) return false;
        int root = (int) Math.sqrt(num);
        int sum = 1;
        if (root * root == num) sum += root;
        else root++;
        for (int i = 2; i < root; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
}