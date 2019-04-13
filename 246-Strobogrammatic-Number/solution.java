class Solution {
    // T: O(n)
    // S: O(1)
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length() - 1;
        while (left < right) {
            char leftCh = num.charAt(left++), rightCh = num.charAt(right--);
            switch (leftCh) {
                case '0': if (rightCh != '0') return false; break;
                case '1': if (rightCh != '1') return false; break;
                case '6': if (rightCh != '9') return false; break;
                case '8': if (rightCh != '8') return false; break;
                case '9': if (rightCh != '6') return false; break;
                default: return false;
            }
        }
        if (left == right && num.charAt(left) != '0'
                && num.charAt(left) != '1' && num.charAt(left) != '8')
            return false;
        return true;
    }
}