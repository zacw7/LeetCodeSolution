class Solution {
    public String maskPII(String S) {
        int at = 0;
        while (at < S.length() && S.charAt(at) != '@') {
            at++;
        }
        if (at == S.length()) {
            // phone
            S = S.replaceAll("[^0-9]", "");
            if (S.length() <= 10) {
                return "***-***-" + S.substring(S.length() - 4);
            } else {
                StringBuilder prefix = new StringBuilder("+");
                for (int i = S.length(); i > 10; i--) {
                    prefix.append('*');
                }
                prefix.append("-***-***-").append(S.substring(S.length() - 4));
                return prefix.toString();
            }
        } else {
            // email
            return (S.substring(0, 1) + "*****" + S.substring(at - 1)).toLowerCase();
        }
    }
}