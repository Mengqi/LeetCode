public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] diff = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            diff[i] = gas[i] - cost[i];
            sum = sum + diff[i];
        }

        if (sum < 0) {
            return -1;
        }

        for (int i = 1; i < length; i++) {
            if ((diff[i] >=0) && (diff[i-1] < 0)) {
                return i;
            }
        }

        return 0;
    }
}
