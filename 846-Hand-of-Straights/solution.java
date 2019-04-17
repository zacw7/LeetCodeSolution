class Solution {
    // T: O(n)
    // S: O(n)
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length % W > 0) {
            return false;
        }

        TreeMap<Integer, Integer> cardCount = new TreeMap();

        for (int c : hand) {
            cardCount.put(c, cardCount.getOrDefault(c, 0) + 1);
        }

        while (!cardCount.isEmpty()) {
            int start = cardCount.firstKey();
            int count = cardCount.get(start) - 1;
            if (count > 0) {
                cardCount.put(start, count);
            } else {
                cardCount.remove(start);
            }
            for (int i = 1; i < W; i++) {
                int curr = start + i;
                if (!cardCount.containsKey(curr)) {
                    return false;
                } else {
                    int cnt = cardCount.get(curr) - 1;
                    if (cnt > 0) {
                        cardCount.put(curr, cnt);
                    } else {
                        cardCount.remove(curr);
                    }
                }
            }
        }

        return true;
    }
}