class Solution {
    public int[][] employeeFreeTime(int[][][] schedule) {
        if (schedule == null || schedule.length == 0) {
            return new int[0][0];
        }

        List<Integer> times = new ArrayList();
        for (int[][] intervals : schedule) {
            for (int[] interval : intervals) {
                times.add(-interval[0]);
                times.add(interval[1]);
            }
        }
        Collections.sort(times, (o1, o2) -> Math.abs(o1) - Math.abs(o2));
        List<int[]> freeTimes = new ArrayList();
        int layer = 0;
        int[] free = null;
        for (int t : times) {
            if (t <= 0) {
                if (layer == 0 && free != null) {
                    free[1] = Math.abs(t);
                    if (free[0] != free[1]) {
                        freeTimes.add(free);
                    }
                    free = null;
                }
                layer++;
            } else {
                layer--;
                if (layer == 0) {
                    free = new int[2];
                    free[0] = Math.abs(t);
                }
            }
        }

        return freeTimes.toArray(new int[freeTimes.size()][2]);
    }
}