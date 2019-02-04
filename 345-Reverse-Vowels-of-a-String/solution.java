class Solution {
    public String reverseVowels(String s) {
        Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int left = 0, right = s.length() - 1;
        while (left < s.length() && !VOWELS.contains(s.charAt(left))) {
            left++;
        }
        if (left == s.length()) return s;
        while (right >= 0 && !VOWELS.contains(s.charAt(right))) {
            right--;
        }
        StringBuilder sb = new StringBuilder(s);
        while (left < right) {
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, s.charAt(left));
            left++;
            right--;
            while (left < s.length() && !VOWELS.contains(s.charAt(left))) {
                left++;
            }
            while (right >= 0 && !VOWELS.contains(s.charAt(right))) {
                right--;
            }
        }
        return sb.toString();
    }
}