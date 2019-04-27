class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length <= 1) {
            return;
        }
        // reverse each word
        int left = 0, right = 0;
        int index = 0;
        while (index <= str.length) {
            if (index == str.length || str[index] == ' ') {
                right = index - 1;
                while (left < right) {
                    char tmp = str[left];
                    str[left] = str[right];
                    str[right] = tmp;
                    left++;
                    right--;
                }
                left = index + 1;
            }
            index++;
        }
        // reverse the entire word
        left = 0;
        right = str.length - 1;
        while (left < right) {
            char tmp = str[left];
            str[left] = str[right];
            str[right] = tmp;
            left++;
            right--;
        }
    }
}