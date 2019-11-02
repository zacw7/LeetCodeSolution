class Solution {
    public int maxLength(List<String> arr) {
        int N = arr.size();
        int[] bitmap = new int[1 << N];
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int bit = 0;
            for (char c : arr.get(i).toCharArray()) {
                int shift = c - 'a';
                if ((bit & (1 << shift)) == 0) {
                    bit |= (1 << shift);
                } else {
                    bit = -1;
                    break;
                }
            }
            bitmap[1 << i] = bit;
        }
        for (int i = 2; i < bitmap.length; i <<= 1) {
            for (int j = 1; j < i; j++) {
                if (bitmap[i] == -1 || bitmap[j] == -1 || (bitmap[i] & bitmap[j]) > 0) {
                    bitmap[i | j] = -1;
                    continue;
                } else {
                    bitmap[i | j] = bitmap[i] | bitmap[j];
                }
            }
        }
        for (int b : bitmap) {
            maxLen = Math.max(maxLen, countBit(b));
        }
        return maxLen;
    }

    Map<Integer, Integer> cache = new HashMap();
    private int countBit(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 26; i++) {
            if ((n & mask) > 0) {
                count++;
            }
            mask <<= 1;
        }
        cache.put(n, count);
        return count;
    }
}