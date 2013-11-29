public class Solution {
    public int jump(int[] A) {
        int length = A.length;
        if (length <= 1) {
            return 0;
        }
        
        int noWay = length+1;
        int jumpLow = 0;
        int jumpHigh = 0;
        int jumpNum = 0;
        while (jumpLow <= jumpHigh) {
            jumpNum++;
            int jumpMax = jumpHigh;
            for (int pos = jumpHigh; pos >= jumpLow; pos--) {
                int jumpLength = A[pos];
                int maxPos = pos+jumpLength;
                if (maxPos >= length-1) {
                    return jumpNum;
                }
                if (maxPos > jumpMax) {
                    jumpMax = maxPos;
                }
            }
            jumpLow = jumpHigh+1;
            jumpHigh = jumpMax;
        }
        return jumpNum;
   }
}
