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
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        
        int pos = 0;
        while (pos < intervals.size()) {
            Interval curr = intervals.get(pos);

            if (newInterval.end < curr.start) {
                intervals.add(pos, newInterval);
                return intervals;
            } else if (newInterval.start > curr.end) {
                pos++;
            } else {
                intervals.remove(pos);
                if (curr.start < newInterval.start) {
                    newInterval.start = curr.start;
                }
                if (curr.end > newInterval.end) {
                    newInterval.end = curr.end;
                }
            }
        }
        
        intervals.add(pos, newInterval);
        return intervals;
    }
}
