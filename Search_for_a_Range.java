public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        range[0] = -1;
        range[1] = -1;

        if ((A == null) || (A.length == 0)) {
            return range;
        }

        range[0] = searchStart(A, target, 0, A.length-1);
        range[1] = searchEnd(A, target, 0, A.length-1);

        return range;
    }

    private int searchStart(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (A[mid] == target) {
            if (mid == 0) {
                return mid;
            } else {
                if (A[mid-1] != target) {
                    return mid;
                } else {
                    return searchStart(A, target, start, mid-1);
                }
            }
        } else if (A[mid] < target) {
            return searchStart(A, target, mid+1, end);
        } else {
            return searchStart(A, target, start, mid-1);
        }
    }

    private int searchEnd(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if (A[mid] == target) {
            if (mid == A.length-1) {
                return mid;
            } else {
                if (A[mid+1] != target) {
                    return mid;
                } else {
                    return searchEnd(A, target, mid+1, end);
                }
            }
        } else if (A[mid] < target) {
            return searchEnd(A, target, mid+1, end);
        } else {
            return searchEnd(A, target, start, mid-1);
        }
    }
}
