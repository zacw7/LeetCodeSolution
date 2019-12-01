class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList();
        int big = tomatoSlices - 2 * cheeseSlices;
        if (big % 2 == 1 || big < 0) {
            return res;
        } else {
            big /= 2;
        }
        int small = cheeseSlices - big;
        if (small < 0) {
            return res;
        }
        res.add(big);
        res.add(small);
        return res;
    }
}