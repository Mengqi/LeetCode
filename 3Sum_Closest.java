public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if ((num == null) || (num.length == 0)) {
            return 0;
        }
        
        if (num.length == 1) {
            return num[0];
        } else if (num.length == 2) {
            return num[0] + num[1];
        }

        int sumMin = num[0] + num[1] + num[2];
        int minDist = getDistance(target, sumMin);
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i+1; j < num.length - 1; j++) {
                for (int k = j+1; k < num.length; k++) {
                    int sum = num[i] + num[j] + num[k];
                    int dist = getDistance(target, sum);
                    if (dist < minDist) {
                        minDist = dist;
                        sumMin = sum;
                        if (dist == 0) {
                            return sumMin;
                        }
                    }
                }
            }
        }
        return sumMin;
    }
    
    private int getDistance(int target, int sum) {
        if (target > sum) {
            return target - sum;
        } else {
            return sum - target;
        }
    }
}