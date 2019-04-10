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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);
        int freeTime = Integer.MIN_VALUE;
        for (Interval itv : intervals) {
            if (itv.start >= freeTime) freeTime = itv.end;
            else return false;
        }
        return true;
    }
}