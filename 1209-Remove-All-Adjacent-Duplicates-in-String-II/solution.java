class Solution {
    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (k == 1) {
            return "";
        }
        Stack<Pair> stack = new Stack();
        char ch = '#';
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) {
                cnt++;
            } else {
                if (cnt > 0) {
                    stack.push(new Pair(ch, cnt));
                }
                ch = c;
                cnt = 1;
            }
            if (cnt >= k) {
                cnt -= k;
            }
            if (cnt == 0 && !stack.isEmpty()) {
                Pair last = stack.pop();
                ch = last.cc;
                cnt = last.cnt;
            }
        }
        if (cnt > 0) {
            stack.push(new Pair(ch, cnt));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            while (p.cnt-- > 0) {
                sb.insert(0, p.cc);
            }
        }
        return sb.toString();
    }

    class Pair {
        char cc;
        int cnt;

        Pair(char cc, int cnt) {
            this.cc = cc;
            this.cnt = cnt;
        }
    }
}