class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int occupied = 0;
        for (int[] c : courses) {
            if (c[1] - occupied >= c[0]) {
                pq.offer(c[0]);
                occupied += c[0];
            } else if (!pq.isEmpty() && pq.peek() > c[0]) {
                occupied -= pq.poll();
                occupied += c[0];
                pq.offer(c[0]);
            }
        }
        return pq.size();
    }
}