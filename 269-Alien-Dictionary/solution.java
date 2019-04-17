class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> indegreeMap = new HashMap();
        Map<Character, List<Character>> adjListMap = new HashMap();

        for (char c : words[0].toCharArray()) {
            indegreeMap.put(c, 0);
        }

        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1], s2 = words[i];
            int idx = 0;
            while (idx < s1.length() && idx < s2.length() && s1.charAt(idx) == s2.charAt(idx)) {
                char c = s1.charAt(idx);
                indegreeMap.put(c, indegreeMap.getOrDefault(c, 0));
                idx++;
            }
            if (idx < s1.length() && idx < s2.length()) {
                // c1 -> c2
                char c1 = s1.charAt(idx), c2 = s2.charAt(idx);
                List<Character> adjList = adjListMap.getOrDefault(c1, new ArrayList());
                adjList.add(c2);
                adjListMap.put(c1, adjList);
                indegreeMap.put(c2, indegreeMap.getOrDefault(c2, 0) + 1);
                idx++;
            }
            while (idx < s1.length() || idx < s2.length()) {
                if (idx < s1.length()) {
                    char c = s1.charAt(idx);
                    indegreeMap.put(c, indegreeMap.getOrDefault(c, 0));
                }
                if (idx < s2.length()) {
                    char c = s2.charAt(idx);
                    indegreeMap.put(c, indegreeMap.getOrDefault(c, 0));
                }
                idx++;
            }
        }

        Queue<Character> queue = new LinkedList();
        for (Map.Entry<Character, Integer> entry : indegreeMap.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            if (adjListMap.containsKey(curr)) {
                List<Character> adjList = adjListMap.get(curr);
                for (char c : adjList) {
                    indegreeMap.put(c, indegreeMap.get(c) - 1);
                    if (indegreeMap.get(c) == 0) {
                        queue.offer(c);
                    }
                }
            }
        }

        for (int indegree : indegreeMap.values()) {
            if (indegree > 0) {
                return "";
            }
        }
        return sb.toString();
    }
}