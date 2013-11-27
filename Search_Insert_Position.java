public class Solution {
    public int searchInsert(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return 0;
        }
        
        if (A[0] >= target) {
            return 0;
        }
        
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == target) {
                return i;
            }
            // target > A[i]
            if (A[i+1] >= target) {
                return i+1;
            }
        }
        return A.length;
    }
}