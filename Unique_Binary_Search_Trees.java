public class Solution {
    public int numTrees(int n) {
        int[] treeNum = new int[n+1];

        for (int i = 0; i <= n; i++) {
            treeNum[i] = 0;
        }
        treeNum[0] = 1;
        treeNum[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <=i ; j++) {
                int leftNum = treeNum[j-1];
                int rightNum = treeNum[i-j];
                treeNum[i] = treeNum[i] + leftNum*rightNum;
            }
        }
        return treeNum[n];
    }
}
