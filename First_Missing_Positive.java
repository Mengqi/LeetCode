public class Solution {
    public int firstMissingPositive(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            while (A[i] != (i+1)) {
                if ((A[i] < 1) || (A[i] > length)) {
                    break;
                } else {
                    if (A[A[i]-1] != A[i]) {
                        swap(A, i, A[i]-1);
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return length+1;
    }

    private void swap(int [] A, int p1, int p2) {
        int temp = A[p1];
        A[p1] = A[p2];
        A[p2] = temp;
    }
}
