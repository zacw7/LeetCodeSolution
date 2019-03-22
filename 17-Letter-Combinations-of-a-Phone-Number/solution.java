class Solution {
    List<char[]> dict = Arrays.asList(" ".toCharArray(), "*".toCharArray(),
            "abc".toCharArray(), "def".toCharArray(),
            "ghi".toCharArray(), "jkl".toCharArray(),
            "mno".toCharArray(), "pqrs".toCharArray(),
            "tuv".toCharArray(), "wxyz".toCharArray());

    List<String> res = new ArrayList();

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() > 0)
            combHelper(new StringBuilder(), digits, 0, digits.length());
        return res;
    }

    private void combHelper(StringBuilder sb, String digits, int cur, int len) {
        if (cur == len) {
            res.add(sb.toString());
            return;
        }
        char[] letters = dict.get(digits.charAt(cur) - '0');;
        for (int i = 0; i < letters.length; i++) {
            sb.append(letters[i]);
            combHelper(sb, digits, cur + 1, len);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}