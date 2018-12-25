class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!((chars[left] >= 'a' && chars[left] <= 'z')
                    || (chars[left] >= 'A' && chars[left] <= 'Z'))) {
                left++;
            } else if (!((chars[right] >= 'a' && chars[right] <= 'z')
                    || (chars[right] >= 'A' && chars[right] <= 'Z'))) {
                right--;
            } else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                right--;
                left++;
            }
        }
        return new String(chars);
    }
}