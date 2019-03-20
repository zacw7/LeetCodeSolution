class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> revealQueue = new LinkedList();
        for (int i = 0; i < deck.length; i++) {
            revealQueue.add(i);
        }
        int[] order = new int[deck.length];
        int index = 0;
        while (index < deck.length && !revealQueue.isEmpty()) {
            order[index++] = revealQueue.poll();
            if (!revealQueue.isEmpty()) {
                revealQueue.add(revealQueue.poll());
            }
        }
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            ans[order[i]] = deck[i];
        }
        return ans;
    }
}