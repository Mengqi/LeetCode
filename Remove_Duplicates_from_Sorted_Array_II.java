public class Solution {
    public int removeDuplicates(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return 0;
        } else if (A.length == 1) {
            return 1;
        }

        int length = 1;
        int min = A[0];
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == min) {
                if (count == 1) {
                    count++;
                    A[length] = A[i];
                    length++;
                }
            } else {
                min = A[i];
                count = 1;
                A[length] = A[i];
                length++;
            }
        }
        return length;
    }
}
