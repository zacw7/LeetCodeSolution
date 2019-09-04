class Solution {
    public String originalDigits(String s) {
        int[] chCount = new int[256];
        int[] digitCount = new int[10];
        for (char c : s.toCharArray()) {
            chCount[c]++;
        }
        digitCount[0] = chCount['z'];
        digitCount[2] = chCount['w'];
        digitCount[4] = chCount['u'];
        digitCount[6] = chCount['x'];
        digitCount[8] = chCount['g'];
        digitCount[3] = chCount['h'] - digitCount[8];
        digitCount[5] = chCount['f'] - digitCount[4];
        digitCount[7] = chCount['v'] - digitCount[5];
        digitCount[1] = chCount['o'] - digitCount[0] - digitCount[2] - digitCount[4];
        digitCount[9] = chCount['i'] - digitCount[5] - digitCount[6] - digitCount[8];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digitCount[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}