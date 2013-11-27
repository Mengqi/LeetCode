public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        Set<Integer> numSet = new HashSet<Integer>();
        
        for (int i = 1; i <= n; i++) {
            numSet.add(i);
        }
        
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        return getComb(prefix, numSet, k);
    }
    
    public ArrayList<ArrayList<Integer>> getComb(ArrayList<Integer> prefix, Set<Integer> numSet, int k) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        
        if (k <= 0) {
            return combinations;
        }
        
        for (int num : numSet) {
            if (k == 1) {
                ArrayList<Integer> comb = new ArrayList<Integer>(prefix);
                comb.add(num);
                combinations.add(comb);
            } else {
                ArrayList<Integer> newPrefix = new ArrayList<Integer>(prefix);
                newPrefix.add(num);
                Set<Integer> newNumSet = new HashSet<Integer>(numSet);
                for (int number : numSet) {
                    if (number <= num) {
                        newNumSet.remove(number);
                    }
                }
                combinations.addAll(getComb(newPrefix, newNumSet, k-1));
            }
        }
        return combinations;
    }
}