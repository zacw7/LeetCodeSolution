class Solution {
    public String toHex(int num) {
        if (num == 0) return String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int mask = 15;
        while (num != 0) {
            int digit = (num & mask);
            if (digit < 10) sb.append((char)(digit + '0'));
            else sb.append((char)(digit - 10 + 'a'));
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}