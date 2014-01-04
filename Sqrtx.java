public class Solution {
    private static int MAX_SQRT = (int) Math.sqrt(Integer.MAX_VALUE);

    public int sqrt(int x) {
        int start = 0;
        int end = x/2 + 1;
        if (end > MAX_SQRT) {
            end = MAX_SQRT;
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            long mid2 = mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return (start + end) / 2;
    }
}
