public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int aPos = m-1;
        int bPos = n-1;
        int pos = m+n-1;
        while ((pos >= 0) && (aPos >= 0) && (bPos >= 0)) {
            if (A[aPos] > B[bPos]) {
                A[pos--] = A[aPos--];
            } else {
                A[pos--] = B[bPos--];
            }
        }
        
        if (aPos >= 0) {
            while (pos >= 0) {
                A[pos--] = A[aPos--];
            }
        } else {
            while (pos >= 0) {
                A[pos--] = B[bPos--];
            } 
        }
    }
}

