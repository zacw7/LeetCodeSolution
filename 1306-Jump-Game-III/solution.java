class Solution {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        int N = arr.length;
        boolean[] reached = new boolean[N];
        Queue<Integer> queue = new LinkedList();
        reached[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int next = cur + arr[cur];
            if (next >= 0 && next < N && !reached[next]) {
                if (arr[next] == 0) {
                    return true;
                }
                reached[next] = true;
                queue.offer(next);
            }
            next = cur - arr[cur];
            if (next >= 0 && next < N && !reached[next]) {
                if (arr[next] == 0) {
                    return true;
                }
                reached[next] = true;
                queue.offer(next);
            }
        }
        return false;
    }
}