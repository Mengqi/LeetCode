public class Solution {
    public int trap(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];

        int max = 0;
        for (int i = 0; i < length; i++) {
            left[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }

        max = 0;
        for (int i = length-1; i >= 0; i--) {
            right[i] = max;
            if (A[i] > max) {
                max = A[i];
            }
        }

        int trapSum = 0;
        for (int i = 0; i < length; i++) {
            int num = 0;
            int height = left[i];
            if (height > right[i]) {
                height = right[i];
            }
            if (height > A[i]) {
                num = height - A[i];
            }
            trapSum = trapSum + num;
        }
        return trapSum;
    }
}
