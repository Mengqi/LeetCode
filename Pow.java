public class Solution {
    public double pow(double x, int n) {
        if (x == 1) {
            return 1;
        } else if (x == -1) {
            return (n % 2 == 0) ? 1 : -1;
        } else if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            return 1 / pow(x, -n);
        } else if (x == 0.0) {
            return 0;
        }

        int mid = n/2;
        double half = pow(x, mid);
        double num = half*half;
        if (n == mid*2+1) {
            num = num*x;
        }
        return num;
    }
}
