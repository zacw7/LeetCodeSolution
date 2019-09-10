class Solution {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked == null || blocked.length < 2) {
            return true;
        }
        int N = 1_000_000;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Set<Long> blockSet = new HashSet();
        Set<Long> sourceSet = new HashSet();
        Set<Long> targetSet = new HashSet();
        Queue<Long> sourceQueue = new LinkedList();
        Queue<Long> targetQueue = new LinkedList();
        sourceSet.add((long) source[0] * N + source[1]);
        targetSet.add((long) target[0] * N + target[1]);
        sourceQueue.offer((long) source[0] * N + source[1]);
        targetQueue.offer((long) target[0] * N + target[1]);
        for (int[] b : blocked) {
            blockSet.add((long) b[0] * N + b[1]);
        }
        int step = 0;
        while (!sourceQueue.isEmpty() && !targetQueue.isEmpty()) {
            int s = sourceQueue.size();
            while (s-- > 0) {
                long cur = sourceQueue.poll();
                for (int[] d : dirs) {
                    long r = cur / N + d[0], c = cur % N + d[1];
                    if (r >= 0 && c >= 0 && r < N && c < N
                            && !blockSet.contains(r * N + c)
                            && !sourceSet.contains(r * N + c)) {
                        if (targetSet.contains(r * N + c)) {
                            return true;
                        } else {
                            sourceSet.add(r * N + c);
                            sourceQueue.offer(r * N + c);
                        }
                    }
                }
            }
            s = targetQueue.size();
            while (s-- > 0) {
                long cur = targetQueue.poll();
                for (int[] d : dirs) {
                    long r = cur / N + d[0], c = cur % N + d[1];
                    if (r >= 0 && c >= 0 && r < N && c < N
                            && !blockSet.contains(r * N + c)
                            && !targetSet.contains(r * N + c)) {
                        if (sourceSet.contains(r * N + c)) {
                            return true;
                        } else {
                            targetSet.add(r * N + c);
                            targetQueue.offer(r * N + c);
                        }
                    }
                }
            }
            if (++step >= blocked.length) {
                break;
            }
        }
        return !sourceQueue.isEmpty() && !targetQueue.isEmpty();
    }
}