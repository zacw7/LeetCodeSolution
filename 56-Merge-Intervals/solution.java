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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) return intervals;
        Map<Integer, Integer> rangeMap = new HashMap();
        for (Interval intv : intervals) {
            int end = rangeMap.getOrDefault(intv.start, intv.start);
            if (intv.end >= end) rangeMap.put(intv.start, intv.end);
        }
        List<Integer> startList = new ArrayList(rangeMap.keySet());
        Collections.sort(startList);
        List<Interval> res = new ArrayList();
        int start = startList.get(0), end = rangeMap.get(start);
        for (int i = 1, size = startList.size(); i < size; i++) {
            int curStart = startList.get(i), curEnd = rangeMap.get(curStart);
            if (curStart > end) {
                res.add(new Interval(start, end));
                start = curStart;
            }
            if (curEnd > end) end = curEnd;
        }
        res.add(new Interval(start, end));
        return res;
    }
}