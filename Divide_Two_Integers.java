public class Solution {
    public int divide(int dividend, int divisor) {
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;
        while (a - b >= 0) {
            long c = b;
            for (int i = 0; a - c >= 0; i++) {
                a = a - c;
                result = result + (1<<i);
                c = c << 1;
            }
        }

        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            result = -result;
        }

        return result;
    }
}
