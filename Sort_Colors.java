public class Solution {
    public void sortColors(int[] A) {
        if ((A == null) || (A.length == 0)) {
            return;
        }
        
        int length = A.length;
        int redPos = -1;
        int bluePos = length;
        
        int pos = 0;
        while (pos < bluePos) {
            if (A[pos] == 0) {
                redPos++;
                A[pos] = 1;
                A[redPos] = 0;
                pos++;
            } else if (A[pos] == 1) {
                pos++;
            } else if (A[pos] == 2) {
                bluePos--;
                A[pos] = A[bluePos];
                A[bluePos] = 2;
            }
        }
    }
}

