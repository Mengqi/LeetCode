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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval  int1, Interval  int2) {
                return  int1.start - int2.start;
            }
        });

        int pos = 1;
        while (pos < intervals.size()) {
            Interval prev = intervals.get(pos-1);
            Interval curr = intervals.get(pos);

            if (prev.end < curr.start) {
                pos++;
            } else {
                if (prev.end < curr.end) {
                    prev.end = curr.end;
                }
                intervals.set(pos-1, prev);
                intervals.remove(pos);
            }
        }

        return intervals;
    }
}
