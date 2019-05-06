class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || start.length() != end.length()) {
            return -1;
        }
        boolean[] visited = new boolean[bank.length];
        Queue<String> mutQueue = new LinkedList();
        mutQueue.offer(start);
        int step = 0;
        while (!mutQueue.isEmpty()) {
            step++;
            int s = mutQueue.size();
            while (s-- > 0) {
                String cur = mutQueue.poll();
                for (int i = 0; i < bank.length; i++) {
                    if (visited[i]) {
                        continue;
                    } else if (isValid(cur, bank[i])) {
                        if (bank[i].equals(end)) {
                            return step;
                        } else {
                            visited[i] = true;
                            mutQueue.offer(bank[i]);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(String from, String to) {
        if (from == null || to == null || from.length() != to.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return diff == 1;
    }
}