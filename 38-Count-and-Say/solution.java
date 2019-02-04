class Solution {
    public String countAndSay(int n) {
        String say = "1";
        while (--n > 0) {
            int count = 0;
            int i = 0;
            char ch = say.charAt(0);
            StringBuilder sb = new StringBuilder();
            while (i < say.length()) {
                if (ch == say.charAt(i)) {
                    count++;
                } else {
                    sb.append(count).append(ch);
                    ch = say.charAt(i);
                    count = 1;
                }
                i++;
            }
            sb.append(count).append(ch);
            say = sb.toString();
        }
        return say;
    }
}