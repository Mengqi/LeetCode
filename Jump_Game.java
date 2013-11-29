public class Solution {
    public boolean canJump(int[] A) {
        if ((A == null) ||(A.length <= 1)) {
            return true;
        }

        int length = A.length;
        boolean[] reachable = new boolean[length];

        for (int i = 0; i < length; i++) {
            reachable[i] = false;
        }
        reachable[length-1] = true;

        for (int i = length-2; i >= 0; i--) {
            int jumpLength = A[i];
            if ((i+jumpLength) >= length-1) {
                reachable[i] = true;
            } else {
                for (int mid = i+1; mid <= i+jumpLength; mid++) {
                    if (reachable[mid] == true) {
                        reachable[i] = true;
                        break;
                    }
                }
            }
        }
        return reachable[0];
    }
}
