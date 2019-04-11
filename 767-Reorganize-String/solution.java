class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> charCount = new HashMap();
        for (char ch : S.toCharArray())
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);

        Queue<Character> queue
                = new PriorityQueue<Character>(
                (o1, o2) -> charCount.getOrDefault(o2, 0) - charCount.getOrDefault(o1, 0));

        for (char ch : charCount.keySet()) queue.add(ch);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            int count = charCount.get(ch);
            if (sb.length() > 0 && ch == sb.charAt(sb.length() - 1)) {
                if (queue.isEmpty()) return "";
                char tmpCh = queue.poll();
                int tmpCount = charCount.get(tmpCh);
                queue.add(ch);
                ch = tmpCh;
                count = tmpCount;
            }
            sb.append(ch);
            count--;
            if (count > 0) {
                charCount.put(ch, count);
                queue.add(ch);
            }
        }
        return sb.toString();
    }
}