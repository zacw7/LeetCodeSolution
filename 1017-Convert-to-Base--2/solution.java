class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        List<Integer> bits = new ArrayList();
        while (N > 0) {
            bits.add(N % 2);
            N /= 2;
        }
        for (int i = 0; i < bits.size(); i++) {
            if (bits.get(i) == 2) {
                bits.set(i, 0);
                if (i + 1 < bits.size()) {
                    bits.set(i + 1, bits.get(i + 1) + 1);
                } else {
                    bits.add(1);
                }
            }
            if (i % 2 > 0 && bits.get(i) == 1) {
                // negtive bit
                if (i + 1 < bits.size()) {
                    bits.set(i + 1, bits.get(i + 1) + 1);
                } else {
                    bits.add(1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bits.size() - 1; i >= 0; i--) sb.append((char) (bits.get(i) + '0'));
        return sb.toString();
    }
}