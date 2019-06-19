class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> visited = new HashSet();
        for (String d : deadends) {
            visited.add(d);
        }
        if (visited.contains("0000") || visited.contains(target)) {
            return -1;
        }
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        visited.add("0000");
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                char[] slots = queue.poll().toCharArray();
                for (int i = 0; i < slots.length; i++) {
                    char c = slots[i];
                    if (c == '0') {
                        slots[i] = '9';
                    } else {
                        slots[i]--;
                    }
                    String next = new String(slots);
                    if (!visited.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                    slots[i] = c;
                    if (c == '9') {
                        slots[i] = '0';
                    } else {
                        slots[i]++;
                    }
                    next = new String(slots);
                    if (!visited.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        visited.add(next);
                        queue.offer(next);
                    }
                    slots[i] = c;
                }
            }
            step++;
        }
        return -1;
    }
}