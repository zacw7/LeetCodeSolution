class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int max = 0, temp = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (P >= tokens[left]) {
                temp++;
                P -= tokens[left++];
                if (temp > max) max = temp;
            } else if (temp > 0) {
                temp--;
                P += tokens[right--];
            } else {
                break;
            }
        }
        return max;
    }
}