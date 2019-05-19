class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        int n = 1;
        while (n++ < N && !queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int num = queue.poll();
                int lastDigit = num % 10;
                num *= 10;
                if (K == 0) {
                    queue.offer(num + lastDigit);
                } else {
                    if (lastDigit - K >= 0) {
                        queue.offer(num + lastDigit - K);
                    }
                    if (lastDigit + K <= 9) {
                        queue.offer(num + lastDigit + K);
                    }
                }
            }
        }
        if (N == 1) {
            queue.offer(0);
        }
        int ans[] = new int[queue.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}