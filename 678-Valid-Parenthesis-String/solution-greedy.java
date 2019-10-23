class Solution {
    // Greedy
    // TC: O(n)
    // SC: O(1)
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen--;
            } else {
                minOpen = Math.max(0, minOpen - 1);
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
        }
        return minOpen == 0;
    }
}