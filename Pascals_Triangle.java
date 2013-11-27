public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rows = new ArrayList<ArrayList<Integer>>();

        if (numRows == 0) {
            return rows;
        }

        ArrayList<Integer> row0 = new ArrayList<Integer>();
        row0.add(0, 1);
        rows.add(0, row0);

        ArrayList<Integer> prevRow = row0;
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> currRow = new ArrayList<Integer>();

            currRow.add(0, 1);
            for (int j = 1; j < i; j++) {
                currRow.add(j, prevRow.get(j-1) + prevRow.get(j));
            }
            currRow.add(i, 1);

            rows.add(i, currRow);
            prevRow = currRow;
        }
        return rows;
    }
}