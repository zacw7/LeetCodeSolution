class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList();
        if (s == null) {
            return res;
        }
        if (isValid(s)) {
            res.add(s);
            return res;
        }
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < cur.length(); i++) {
                    if ((cur.charAt(i) == '(' || cur.charAt(i) == ')')
                            && (i == 0 || cur.charAt(i) != cur.charAt(i - 1))) {
                        String next = cur.substring(0, i) + cur.substring(i + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            if (isValid(next)) {
                                res.add(next);
                            } else {
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            if (!res.isEmpty()) {
                break;
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        int left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') left--;
            if (left < 0) return false;
        }
        return left == 0;
    }
}