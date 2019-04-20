class Solution {
    public String getHint(String secret, String guess) {
        int[] target = new int[10];
        for (char c : secret.toCharArray()) {
            int n = c - '0';
            target[n]++;
        }

        int bulls = 0, cows = 0;
        for (char c : guess.toCharArray()) {
            int n = c - '0';
            if (target[n] > 0) {
                cows++;
                target[n]--;
            }
        }

        for (int i = 0, len = Math.min(secret.length(), guess.length()); i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                cows--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}