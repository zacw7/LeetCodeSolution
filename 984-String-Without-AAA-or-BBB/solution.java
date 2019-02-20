class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        while (A > 0 || B > 0) {
            if (A > B) {
                if (A >= 2) {
                    sb.append("aa");
                    A -= 2;
                    if (B > 0) {
                        sb.append('b');
                        B--;
                    }
                } else {
                    sb.append('a');
                    A--;
                }
            } else if (A < B) {
                if (B >= 2) {
                    sb.append("bb");
                    B -= 2;
                    if (A > 0) {
                        sb.append('a');
                        A--;
                    }
                } else {
                    sb.append('b');
                    B--;
                }
            } else {
                sb.append("ab");
                A--;
                B--;
            }
        }
        return sb.toString();
    }
}