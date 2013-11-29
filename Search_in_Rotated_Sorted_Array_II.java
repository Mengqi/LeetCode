public class Solution {
    public boolean search(int[] A, int target) {
        return binSearch(A, 0, A.length-1, target);
    }

    private boolean binSearch(int [] A, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start+end)/2;

        if (A[mid] == target) {
            return true;
        }

        if (A[mid] > A[start]) {
            if ((target > A[mid]) || (target < A[start])) {
                return binSearch(A, mid+1, end, target);
            } else {
                return binSearch(A, start, mid-1, target);
            }
        } else if (A[mid] < A[start]) {
            if ((target < A[mid]) || (target > A[end])) {
                return binSearch(A, start, mid-1, target);
            } else {
                return binSearch(A, mid+1, end, target);
            }
        } else {    // A[mid] == A[start]
            return binSearch(A, start+1, end, target);
        }
    }
}
