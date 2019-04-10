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
    public int minMeetingRooms(Interval[] intervals) {
        int[] start = new int[intervals.length], end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int room = 0, max = room;
        int i = 0, j = 0;
        while (i < start.length) {
            if (start[i] < end[j]) {
                i++;
                room++;
            } else {
                room--;
                j++;
            }
            max = Math.max(max, room);
        }
        return max;
    }
}