/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    // T: O(nlogn + n)
    // S: O(n) - a boolean array used
    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) {
            return;
        }

        Arrays.sort(wordlist);
        boolean[] candidates = new boolean[wordlist.length];
        Arrays.fill(candidates, true);
        while (true) {
            int pick = 0;
            while (candidates[pick] == false) {
                pick++;
            }
            int match = master.guess(wordlist[pick]);
            if (match == 6) {
                break;
            } else {
                candidates[pick] = false;
            }
            for (int i = 0; i < wordlist.length; i++) {
                if (candidates[i] && match != matchedCount(wordlist[pick], wordlist[i])) {
                    candidates[i] = false;
                }
            }
        }
    }

    private int matchedCount(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}