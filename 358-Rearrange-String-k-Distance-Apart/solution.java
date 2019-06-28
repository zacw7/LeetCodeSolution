class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                queue.offer((char)(i + 'a'));
            }
        }
        int[] last = new int[26];
        Arrays.fill(last, -1);
        char[] chs = new char[s.length()];
        Arrays.fill(chs, ' ');
        for (int i = 0; i < chs.length; i++) {
            List<Character> tmp = new ArrayList();
            while (!queue.isEmpty()) {
                Character c = queue.poll();
                if (last[c - 'a'] >= 0 && i - last[c - 'a'] < k) {
                    tmp.add(c);
                } else {
                    chs[i] = c;
                    last[c - 'a'] = i;
                    if (--count[c - 'a'] > 0) {
                        tmp.add(c);
                    }
                    break;
                }
            }
            if (chs[i] == ' ') {
                return "";
            } else {
                queue.addAll(tmp);
            }
        }
        return new String(chs);
    }
}