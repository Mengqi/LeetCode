/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {

    public int maxPoints(Point[] points) {
        int length = points.length;
        if (length <= 2) {
            return length;
        }

        HashMap<Double, HashMap<Double, HashSet<Point>>> aMap = new HashMap<Double, HashMap<Double,
        HashSet<Point>>>();

        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];
                double a, b;
                if (p1.x == p2.x) {
                    a = 1;
                    b = -p1.x;
                } else {
                    a = (double) (p1.y - p2.y) / (p1.x - p2.x);
                    if (p1.y > p2.y) {
                        b = p1.y - a*p1.x;
                    } else {
                        b = p2.y - a*p2.x;
                    }
                }
                if (!aMap.containsKey(a)) {
                    HashMap<Double, HashSet<Point>> bMap = new HashMap<Double, HashSet<Point>>();
                    HashSet<Point> pointSet = new HashSet<Point>();
                    pointSet.add(p1);
                    pointSet.add(p2);
                    bMap.put(b, pointSet);
                    aMap.put(a, bMap);
                } else {
                    HashMap<Double, HashSet<Point>> bMap = aMap.get(a);
                    if (bMap.containsKey(b)) {
                        HashSet<Point> pointSet = bMap.get(b);
                        if (!pointSet.contains(p1)) {
                            pointSet.add(p1);
                        }
                        if (!pointSet.contains(p2)) {
                            pointSet.add(p2);
                        }
                        bMap.put(b, pointSet);
                    } else {
                        HashSet<Point> pointSet = new HashSet<Point>();
                        pointSet.add(p1);
                        pointSet.add(p2);
                        bMap.put(b, pointSet);
                    }
                }
            }
        }

        int max = 0;
        for (double a : aMap.keySet()) {
            HashMap<Double, HashSet<Point>> bMap = aMap.get(a);
            for (double b : bMap.keySet()) {
                HashSet<Point> pointSet = bMap.get(b);
                if (pointSet.size() > max) {
                    max = pointSet.size();
                }
            }
        }
        return max;
    }
}
