public class Solution {
    public int singleNumber(int[] A) {
        int num = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            num = num^A[i];
        }
        return num;
    }
}
