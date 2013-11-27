public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }
        
        int length = 1;
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > min) {
                A[length] = A[i];
                min = A[i];
                length++;
            }
        }
        
        return length;
    }
}