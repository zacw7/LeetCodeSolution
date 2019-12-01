class Solution {
    public String toHexspeak(String num) {
        String hex = Long.toHexString(new Long(num)).toUpperCase();
        char[] res = hex.toCharArray();
        for (int i = 0; i < res.length; i++) {
            if (res[i] == '0') {
                res[i] = 'O';
            } else if (res[i] == '1') {
                res[i] = 'I';
            } else if (res[i] != 'A' && res[i] != 'B' && res[i] != 'C'
                    && res[i] != 'D' && res[i] != 'E' && res[i] != 'F') {
                return "ERROR";
            }
        }
        return new String(res);
    }
}