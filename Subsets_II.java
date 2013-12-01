public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        return subsets(num, num.length-1);
    }

    private ArrayList<ArrayList<Integer>> subsets(int[] num, int pos) {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();

        int length = num.length;
        if (pos > length) {
            return sets;
        } else if (pos == 0) {
            int number = num[0];
            ArrayList<Integer> s0 = new ArrayList<Integer>();
            sets.add(s0);
            ArrayList<Integer> s1 = new ArrayList<Integer>();
            s1.add(number);
            sets.add(s1);
            return sets;
        }

        ArrayList<ArrayList<Integer>> prefixes = subsets(num, pos-1);

        int number = num[pos];
        for (ArrayList<Integer> prefix : prefixes) {
            ArrayList<Integer> s0 = new ArrayList<Integer>(prefix);
            if (!sets.contains(s0)) {
                sets.add(s0);
            }
            ArrayList<Integer> s1 = new ArrayList<Integer>(prefix);
            s1.add(number);
            if (!sets.contains(s1)) {
                sets.add(s1);
            }
        }

        return sets;
    }
}
