public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> currRow = new ArrayList<Integer>(rowIndex+1);
        ArrayList<Integer> nextRow = new ArrayList<Integer>(rowIndex+1);

        for (int i = 0; i <= rowIndex; i++) {
            currRow.add(0);
            nextRow.add(0);
        }

        currRow.set(0, 1);
        for (int i = 1; i <= rowIndex; i++) {
            nextRow.set(0,1);
            for (int j = 1; j < i; j++) {
                nextRow.set(j, currRow.get(j-1) + currRow.get(j));
            }
            nextRow.set(i, 1);
            ArrayList<Integer> temp = currRow;
            currRow = nextRow;
            nextRow = temp;
        }
        return currRow;
    }
}