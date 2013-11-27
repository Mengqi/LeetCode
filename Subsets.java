public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        
        if ((S == null) || (S.length == 0)) {
            return sets;
        }
        
        Arrays.sort(S);

        ArrayList<Integer> prefix = new ArrayList<Integer>();
        
        return getSubsets(prefix, S, 0, S.length-1);
    }
    
    private ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> prefix, int[] S, int start, int end) {
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        
        if (start > end) {
            return sets;
        } else if (start == end) {
            ArrayList<Integer> set0 = new ArrayList<Integer>(prefix);
            sets.add(set0);
            ArrayList<Integer> set1 = new ArrayList<Integer>(prefix);
            set1.add(S[start]);
            sets.add(set1);
        } else {
            ArrayList<Integer> prefx0 = new ArrayList<Integer>(prefix);
            ArrayList<ArrayList<Integer>> sets0 = getSubsets(prefix0, S, start+1, end);
            sets.addAll(sets0);
            
            ArrayList<Integer> prefix1 = new ArrayList<Integer>(prefix);
            prefix1.add(S[start]);
            ArrayList<ArrayList<Integer>> sets1 = getSubsets(prefix1, S, start+1, end);
            sets.addAll(sets1);
        }
        return sets;
    }
}