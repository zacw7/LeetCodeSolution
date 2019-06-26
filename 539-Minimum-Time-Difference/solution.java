class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] ts = new int[timePoints.size()];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = convert2Mins(timePoints.get(i));
        }
        Arrays.sort(ts);
        int min = 24 * 60 - ts[ts.length - 1] + ts[0];
        for (int i = 1; i < ts.length; i++) {
            min = Math.min(min, ts[i] - ts[i - 1]);
        }
        return min;
    }

    private int convert2Mins(String tp) {
        int h = Integer.valueOf(tp.substring(0, 2));
        int m = Integer.valueOf(tp.substring(3));
        return h * 60 + m;
    }
}