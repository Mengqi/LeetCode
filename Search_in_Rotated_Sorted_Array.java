public class Solution {
    public int search(int[] A, int target) {
        if ((A == null) || (A.length == 0)) {
            return -1;
        }
        
        int length = A.length;
        int zero = getZeroPos(A, 0, length-1);
        
        int pos = -1;
        if (zero == 0) {
            pos = binarySearch(A, target, 0, length -1);
        } else {
            int mid = A[0];
            if (mid > target) {
                pos = binarySearch(A, target, zero, length -1);
            } else {
                pos = binarySearch(A, target, 0, zero-1);
            }
        }
        
        return pos;
    }
    
    private int getZeroPos(int [] A, int start, int end) {
        int minMax = A[start];
        int maxMin = A[end];
        int mid = (start+end)/2;
        
        if (minMax <= maxMin) {
            return start;
        }

        if (mid == start) { // only 2 left
            return end;
        }
        
        if (A[mid] >= minMax) {
            return getZeroPos(A, mid+1, end);
        } else {
            return getZeroPos(A, start, mid);
        }
    }
    
    private int binarySearch(int [] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start+end)/2;
        if (A[mid] == target) {
            return mid;
        } else if (A[mid] > target) {
            return binarySearch(A, target, start, mid-1);
        } else {
            return binarySearch(A, target, mid+1, end);
        }
    }
    
}