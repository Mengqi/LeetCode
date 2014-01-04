/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Interval target = newInterval;

        int pos = 0;
        while (pos < intervals.size()) {
            Interval curr = intervals.get(pos);
            if (target.end < curr.start) {
                intervals.add(pos, target);
                break;
            } else if (target.start > curr.end) {
                pos++;
            } else {
                // need to merge
                if ((target.start == curr.start) && (target.end == curr.end)) {
                    break;
                } else if ((target.start <= curr.start) && (target.end >= curr.end)) {
                    intervals.remove(pos);
                } else if ((target.start >= curr.start) && (target.end <= curr.start)) {
                    break;
                } else {
                    if (target.start > curr.start) {
                        target.start = curr.start;
                    }
                    if (target.end < curr.end) {
                        target.end = curr.end;
                    }
                    intervals.remove(pos);
                }
            }
        }

        if (pos == intervals.size()) {
            intervals.add(target);
        }

        return intervals;
    }
}
