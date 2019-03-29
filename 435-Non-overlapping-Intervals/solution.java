/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals,
                (o1, o2) -> (o1.end == o2.end) ? o1.start - o2.start : o1.end - o2.end);
        int leftBound = Integer.MIN_VALUE, count = 0;
        for (Interval i : intervals) {
            if (i.start < leftBound) count++;
            else if (i.end > leftBound) leftBound = i.end;
        }
        return count;
    }
}