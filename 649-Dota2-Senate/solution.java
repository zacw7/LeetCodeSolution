class Solution {
    public String predictPartyVictory(String senate) {
        char[] senates = senate.toCharArray();
        for (int i = 0; true; i++) {
            i %= senates.length;
            if (senates[i] == 'R') {
                int j = i + 1;
                j %= senates.length;
                while (j != i && senates[j] != 'D') {
                    j++;
                    j %= senates.length;
                }
                if (j == i) {
                    return "Radiant";
                } else {
                    senates[j] = 'X';
                }
            } else if (senates[i] == 'D') {
                int j = i + 1;
                j %= senates.length;
                while (j != i && senates[j] != 'R') {
                    j++;
                    j %= senates.length;
                }
                if (j == i) {
                    return "Dire";
                } else {
                    senates[j] = 'X';
                }
            }
        }
    }
}