class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> ts = new ArrayList();
        for (int[] itv : intervals) {
            ts.add(itv[0]);
            ts.add(-itv[1]);
        }
        Collections.sort(ts, (a, b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a - b;
            } else {
                return Math.abs(a) - Math.abs(b);
            }
        });
        int maxRoom = 0;
        int count = 0;
        for (int t : ts) {
            if (t >= 0) {
                count++;
            } else {
                count--;
            }
            maxRoom = Math.max(maxRoom, count);
        }
        return maxRoom;
    }
}