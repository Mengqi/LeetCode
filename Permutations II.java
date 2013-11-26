public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
        if ((num == null) || (num.length == 0)) {
            return perms;
        }
        return permutations(num, num.length);
    }

    private ArrayList<ArrayList<Integer>> permutations(int [] num, int length) {
        ArrayList<ArrayList<Integer>> perms = new ArrayList<ArrayList<Integer>>();
        if (length == 1) {
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            perms.add(perm);
            return perms;
        }
        ArrayList<ArrayList<Integer>> prefixes = permutations(num, length-1);
        for (ArrayList<Integer> prefix : prefixes) {
            for (int i = 0; i <= prefix.size(); i++) {
                ArrayList<Integer> perm = new ArrayList<Integer>(prefix);
                perm.add(i, num[length-1]);
                if (!perms.contains(perm)) {
                    perms.add(perm);
                }
            }
        }
        return perms;
    }
}
