public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        return subsetSum(num, 0, prefix, target);
    }

    private ArrayList<ArrayList<Integer>> subsetSum(int[] num, int pos, ArrayList<Integer> prefix, int target) {
        ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();

        if (target == 0) {
            if (!sums.contains(prefix)) {
                sums.add(prefix);
            }
            return sums;
        }
        int length = num.length;
        if (pos >= length) {
            return sums;
        }

        int number = num[pos];
        if (number <= target) {
            ArrayList<Integer> prefix0 = new ArrayList<Integer>(prefix);
            ArrayList<ArrayList<Integer>> sums0 = subsetSum(num, pos+1, prefix0, target);
            for (ArrayList<Integer> sum : sums0) {
                if (!sums.contains(sum)) {
                    sums.add(sum);
                }
            }
            ArrayList<Integer> prefix1 = new ArrayList<Integer>(prefix);
            prefix1.add(number);
            ArrayList<ArrayList<Integer>> sums1 = subsetSum(num, pos+1, prefix1, target-number);
            for (ArrayList<Integer> sum : sums1) {
                if (!sums.contains(sum)) {
                    sums.add(sum);
                }
            }
        }
        return sums;
    }
}
