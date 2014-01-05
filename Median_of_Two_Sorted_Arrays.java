public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int aLength = A.length;
        int bLength = B.length;
        int length = aLength + bLength;
        
        double median;
        if (length % 2 == 0) {
            int median1 = findKthElement(A, 0, aLength-1, B, 0, bLength-1, length/2);
            int median2 = findKthElement(A, 0, aLength-1, B, 0, bLength-1, length/2+1);
            median = (double) (median1 + median2) / 2;
        } else {
            median = findKthElement(A, 0, aLength-1, B, 0, bLength-1, length/2+1);
        }
        return median;
    }
    
    private int findKthElement(int A[], int aStart, int aEnd, int B[], int bStart, int bEnd, int k) {
        if (aStart > aEnd) {
            return B[bStart + k - 1];
        }
        if (bStart > bEnd) {
            return A[aStart + k - 1];
        }

        int aLength = aEnd - aStart + 1;
        int bLength = bEnd - bStart + 1;
        int aMid = (aStart + aEnd) / 2; // also = (aStart + 0 + aStart + aLength - 1) / 2 = aStart + (aLength - 1) / 2
        int bMid = (bStart + bEnd) / 2; // also = (bStart + 0 + bStart + bLength - 1) / 2 = bStart + (bLength - 1) / 2
        if (k <= (aLength-1)/2 + (bLength-1)/2 + 1) {
            // discard largest half including the median
            if (A[aMid] > B[bMid]) {
                return findKthElement(A, aStart, aMid-1, B, bStart, bEnd, k);
            } else {
                return findKthElement(A, aStart, aEnd, B, bStart, bMid-1, k);
            }
        } else {
            // discard smallest half including the median
            if (A[aMid] < B[bMid]) {
                return findKthElement(A, aMid+1, aEnd, B, bStart, bEnd, k - (aMid - aStart + 1));
            } else {
                return findKthElement(A, aStart, aEnd, B, bMid+1, bEnd, k - (bMid - bStart + 1));
            }
        }
    }
}
