class Solution {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        int N = A.length();
        Queue<String> queue = new LinkedList();
        Set<String> seen = new HashSet();
        queue.offer(A);
        seen.add(A);
        int k = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            k++;
            while (sz-- > 0) {
                String cur = queue.poll();
                for (int i = 0; i < N; i++) {
                    if (cur.charAt(i) == B.charAt(i)) {
                        continue;
                    }
                    char[] chs = cur.toCharArray();
                    for (int j = i + 1; j < N; j++) {
                        if (cur.charAt(j) != B.charAt(i)) {
                            continue;
                        }
                        swap(chs, i, j);
                        String neigh = new String(chs);
                        swap(chs, i, j);
                        if (!seen.contains(neigh)) {
                            if (neigh.equals(B)) {
                                return k;
                            }
                            seen.add(neigh);
                            queue.offer(neigh);
                        }
                    }
                    break;
                }
            }
        }
        return -1;
    }

    private void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}