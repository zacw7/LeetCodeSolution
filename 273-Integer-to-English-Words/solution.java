class Solution {

    private String[] NUM_ONES_STR = {"Zero", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private String[] NUM_TENS_STR = {
            "Zero", "Ten", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private String[] NUM_THOUSANDS_STR = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        if (num < 20) return NUM_ONES_STR[num];
        List<String> groups = new ArrayList();
        while(num > 0) {
            int cur = num % 1000;
            String str = null;
            if (cur > 0) str = helper(num % 1000) + NUM_THOUSANDS_STR[groups.size()];
            groups.add(str);
            num /= 1000;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = groups.size() - 1; i >= 0; i--) {
            String s = groups.get(i);
            if (s != null) ans.append(s).append(' ');
        }
        return ans.toString().trim();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        int digit1 = num % 10;
        num /= 10;
        int digit2 = num % 10;
        num /= 10;
        int digit3 = num;
        if (digit3 > 0) {
            sb.append(NUM_ONES_STR[digit3]).append(' ').append("Hundred");
            if (digit2 > 0 || digit1 > 0) sb.append(' ');
        }
        if (digit2 < 2) {
            if (digit2 > 0 || digit1 > 0) {
                sb.append(NUM_ONES_STR[digit2 * 10 + digit1]);
            }
        } else {
            sb.append(NUM_TENS_STR[digit2]);
            if (digit1 > 0) sb.append(' ').append(NUM_ONES_STR[digit1]);
        }
        return sb.toString();
    }
}