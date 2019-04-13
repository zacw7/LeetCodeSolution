class Solution {
    // T: O(4^n)
    // S: O(1)
    public List<String> findStrobogrammatic(int n) {
        List<String> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            helper(n, sb, ans);
        } else {
            sb.append('0');
            helper(n - 1, sb, ans);
            sb.setLength(0);
            sb.append('1');
            helper(n - 1, sb, ans);
            sb.setLength(0);
            sb.append('8');
            helper(n - 1, sb, ans);
            sb.setLength(0);
        }
        return ans;
    }

    private void helper(int n, StringBuilder sb, List<String> ans) {
        if (n == 0) {
            ans.add(sb.toString());
        } else {
            if (n > 2) {
                sb.insert(0, '0');
                sb.append('0');
                helper(n - 2, sb, ans);
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.insert(0, '1');
            sb.append('1');
            helper(n - 2, sb, ans);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);

            sb.insert(0, '8');
            sb.append('8');
            helper(n - 2, sb, ans);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);

            sb.insert(0, '6');
            sb.append('9');
            helper(n - 2, sb, ans);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);

            sb.insert(0, '9');
            sb.append('6');
            helper(n - 2, sb, ans);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}