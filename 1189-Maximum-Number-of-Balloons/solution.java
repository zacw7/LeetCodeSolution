class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int maxBalloon = Integer.MAX_VALUE;
        maxBalloon = Math.min(maxBalloon, count['b' - 'a']);
        maxBalloon = Math.min(maxBalloon, count['a' - 'a']);
        maxBalloon = Math.min(maxBalloon, count['n' - 'a']);
        maxBalloon = Math.min(maxBalloon, count['l' - 'a'] / 2);
        maxBalloon = Math.min(maxBalloon, count['o' - 'a'] / 2);
        return maxBalloon;
    }
}