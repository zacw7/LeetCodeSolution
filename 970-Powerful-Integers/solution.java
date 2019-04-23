class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        if (x == 1 && y == 1) {
            if (bound >= 2) {
                seen.add(2);
            }
        } else if (x == 1 || y == 1) {
            x = Math.max(x, y);
            for (int i = 0; Math.pow(x, i) + 1<= bound; i++) {
                seen.add((int) (Math.pow(x, i) + 1));
            }
        } else {
            for (int i = 0; Math.pow(x, i) <= bound; i++) {
                for (int j = 0; Math.pow(x, i) + Math.pow(y, j) <= bound; j++) {
                    seen.add((int) (Math.pow(x, i) + Math.pow(y, j)));
                }
            }
        }
        return new ArrayList(seen);
    }
}