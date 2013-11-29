public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        int [] candidatesSorted = new int[length];
        System.arraycopy(candidates, 0, candidatesSorted, 0, length);
        Arrays.sort(candidatesSorted);
        return subsetSum(candidatesSorted, 0, new ArrayList<Integer>(), target);
    }

    private ArrayList<ArrayList<Integer>> subsetSum(int[] candidates, int pos, ArrayList<Integer> prefix, int sum)
    {
        ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();

        if (sum == 0) {
            sums.add(prefix);
            return sums;
        }
        int length = candidates.length;
        if (pos >= length) {
            return sums;
        }

        int num = candidates[pos];
        if (num <= sum) {
            int count = sum / num;
            for (int i = 0; i <= count; i++) {
                ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
                for (int j = 0; j < i; j++) {
                    newPrefix.add(num);
                }
                ArrayList<ArrayList<Integer>> newSum = subsetSum(candidates, pos+1, newPrefix, sum-num*i);
                sums.addAll(newSum);
            }
        }
        return sums;
    }
}
