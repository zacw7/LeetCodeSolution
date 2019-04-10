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
        int room = 0;
        List<Interval> list = new ArrayList(intervals.length);
        for (Interval itv : intervals) list.add(itv);
        Collections.sort(list, (o1, o2) -> (o1.start == o2.start) ? o1.end - o2.end : o1.start - o2.start);
        while (!list.isEmpty()) {
            room++;
            int bound = Integer.MIN_VALUE;
            List<Interval> removed = new ArrayList();
            for (Interval itv : list) {
                if (itv.start < bound) continue;
                bound = itv.end;
                removed.add(itv);
            }
            list.removeAll(removed);
        }
        return room;
    }
}