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
        Arrays.sort(intervals, (o1, o2) -> o1.start - o2.start);
        Queue<Integer> heap = new PriorityQueue();
        for (Interval itv : intervals) {
            if (!heap.isEmpty() && itv.start >= heap.peek()) heap.poll();
            heap.add(itv.end);
        }
        return heap.size();
    }
}