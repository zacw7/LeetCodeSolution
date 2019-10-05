class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        int LIMIT = 200_000_000;
        List<Integer> res = new ArrayList();
        List<Integer> cur = new ArrayList();
        if (0 >= low && 0 <= high) {
            res.add(0);
        }
        for (int i = 1; i < 10; i++) {
            cur.add(i);
        }
        while (!cur.isEmpty()) {
            List<Integer> tmp = new ArrayList();
            for (int n : cur) {
                if (n > 0 && n <= high) {
                    int lastDigit = n % 10;
                    if (n <= LIMIT && lastDigit > 0) {
                        tmp.add(n * 10 + lastDigit - 1);
                    }
                    if (n <= LIMIT && lastDigit < 9) {
                        tmp.add(n * 10 + lastDigit + 1);
                    }
                    if (n >= low) {
                        res.add(n);
                    }
                }
            }
            cur = tmp;
        }
        return res;
    }
}