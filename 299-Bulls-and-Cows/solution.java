class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> targetMap = new HashMap();
        for (char c : secret.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int bulls = 0, cows = 0;
        for (char c : guess.toCharArray()) {
            if (targetMap.containsKey(c)) {
                cows++;
                int remain = targetMap.get(c) - 1;
                if (remain == 0) {
                    targetMap.remove(c);
                } else {
                    targetMap.put(c, remain);
                }
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