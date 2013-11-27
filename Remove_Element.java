public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int length = A.length;
        for (int i = 0; i < length; i++) {
            if (A[i] == elem) {
                while ((length > 0) &&(A[length-1] == elem)) {
                    length--;
                }
                if (length-1 > i) {
                    length--;
                    A[i] = A[length];
                }
            }
        }
        return length;
    }
}