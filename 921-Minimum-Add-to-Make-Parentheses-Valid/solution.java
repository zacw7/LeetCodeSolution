class Solution {
    public int minAddToMakeValid(String S) {
        int leftCount = 0, ans = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                leftCount++;
            } else if (ch == ')') {
                if (leftCount > 0) leftCount--;
                else ans++;
            }
        }
        return ans + leftCount;
    }
}