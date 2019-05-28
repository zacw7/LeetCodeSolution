class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList();
        int num = 0;
        for (int bit : A) {
            num = (num << 1) + bit;
            res.add(num % 5 == 0);
            num %= 5;
        }
        return res;
    }
}