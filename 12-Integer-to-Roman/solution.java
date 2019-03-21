class Solution {
    public String intToRoman(int num) {
        String[] dict = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] digits = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            int count = num / digits[i];
            num -= count * digits[i];
            while (count-- > 0) sb.append(dict[i]);
        }
        return sb.toString();
    }
}