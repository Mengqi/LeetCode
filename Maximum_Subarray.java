public class Solution {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > max) {
                max = sum;
            }
        }
        
        if (max == 0) {
            // case that all num are negative;
            max = A[0];
            for (int i = 0; i < A.length; i++) {
                if (max < A[i]) {
                    max = A[i];
                }
            }
        }
        
        return max;
    }
}