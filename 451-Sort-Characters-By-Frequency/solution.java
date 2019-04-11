class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charCount = new HashMap();
        for (char c : s.toCharArray()) charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        Queue<Character> queue = new PriorityQueue<Character>((o1, o2) -> charCount.getOrDefault(o2, 0) - charCount.getOrDefault(o1, 0));
        for (Character ch: charCount.keySet()) queue.add(ch);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            int count = charCount.get(ch);
            while (count-- > 0) sb.append(ch);
        }
        return sb.toString();
    }
}