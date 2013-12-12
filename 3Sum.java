public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int length = num.length;
        for (int i = 0; i < length-2; i++) {
            if ((i == 0) || (num[i] != num[i-1])) {
                int target = - num[i];
                int j = i+1;
                int k = length-1;
                while (j < k) {
                    if ((num[j] + num[k]) == target) {
                        ArrayList<Integer> sum = new ArrayList<Integer>();
                        sum.add(num[i]);
                        sum.add(num[j]);
                        sum.add(num[k]);
                        sums.add(sum);
                        j++;
                        k--;
                        while ((j < k) && (num[j-1] == num[j])) {
                            j++;
                        }
                        while ((k > j) && (num[k] == num[k+1])) {
                            k--;
                        }
                    } else if ((num[j] + num[k]) > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return sums;
    }
}
