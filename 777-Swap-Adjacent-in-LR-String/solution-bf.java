class Solution {
    // BFS [TLE]
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        if (start.equals(end)) {
            return true;
        }
        Queue<String> queue = new LinkedList();
        Set<String> seen = new HashSet();
        seen.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            char[] chars = queue.poll().toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if ((chars[i - 1] == 'X' && chars[i] == 'L')
                        || (chars[i - 1] == 'R' && chars[i] == 'X')) {
                    // swap
                    swap(chars, i - 1, i);
                    String s = new String(chars);
                    if (!seen.contains(s)) {
                        if (s.equals(end)) {
                            return true;
                        }
                        seen.add(s);
                        queue.offer(s);
                    }
                    swap(chars, i - 1, i);
                }
            }
        }
        return false;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}