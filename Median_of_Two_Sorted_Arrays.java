public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length = A.length + B.length;
        if (length % 2 == 0) {
            int median1 = findKthElement(A, 0, A.length-1, B, 0, B.length-1, length/2);
            int median2 = findKthElement(A, 0, A.length-1, B, 0, B.length-1, length/2+1);
            double median = (double)(median1 + median2) / 2;
            return median;
        } else {
            double median = findKthElement(A, 0, A.length-1, B, 0, B.length-1, length/2+1);
            return median;
        }
    }

    // k start from 0
    private int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
        if (aStart > aEnd) {
            return B[bStart + k - 1];
        }

        if (bStart > bEnd) {
            return A[aStart + k - 1];
        }

        int aLength = aEnd - aStart + 1;
        int bLength = bEnd - bStart + 1;
        int aMid = (aStart + aEnd) / 2;
        int bMid = (bStart + bEnd) / 2;
        if (k <= (aLength-1)/2 + (bLength-1)/2 + 1) {
            // discard large half with Mid
            if (A[aMid] > B[bMid]) {
                // [aStart, aMid] [bStart, bEnd]
                return findKthElement(A, aStart, aMid-1, B, bStart, bEnd, k);
            } else {
                // [aStart, aEnd] [bStart, bMid]
                return findKthElement(A, aStart, aEnd, B, bStart, bMid-1, k);
            }
        } else {
            // discard small half with Mid
            if (A[aMid] > B[bMid]) {
                return findKthElement(A, aStart, aEnd, B, bMid+1, bEnd, k - (bMid + 1 - bStart));
            } else {
                return findKthElement(A, aMid+1, aEnd, B, bStart, bEnd, k - (aMid + 1 - aStart));
            }
        }
    }
}
