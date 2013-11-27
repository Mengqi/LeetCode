public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int max = A[0];
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum = sum + A[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
}