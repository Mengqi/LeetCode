public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> numList = new ArrayList<Integer>();

        int m = matrix.length;
        if (m == 0) {
            return numList;
        }

        int n = matrix[0].length;
        if (n == 0) {
            return numList;
        }

        spiralTraverse(matrix, 0, m-1, 0, n-1, numList);

        return numList;
    }

    private void spiralTraverse(int [][] matrix, int xStart, int xEnd, int yStart, int yEnd, ArrayList<Integer>
    numList) {
        if ((xStart > xEnd) || (yStart > yEnd)) {
            return;
        }

        if (xStart == xEnd) {
            for (int i = yStart; i <= yEnd; i++) {
                numList.add(matrix[xStart][i]);
            }
            return;
        } else if (yStart == yEnd) {
            for (int i = xStart; i <= xEnd; i++) {
                numList.add(matrix[i][yStart]);
            }
            return;
        }

        for (int i = yStart; i <= yEnd; i++) {
            numList.add(matrix[xStart][i]);
        }

        for (int i = xStart+1; i <= xEnd; i++) {
            numList.add(matrix[i][yEnd]);
        }

        for (int i = yEnd-1; i >= yStart; i--) {
            numList.add(matrix[xEnd][i]);
        }

        for (int i = xEnd-1; i > xStart; i--) {
            numList.add(matrix[i][yStart]);
        }

        spiralTraverse(matrix, xStart+1, xEnd-1, yStart+1, yEnd-1, numList);
    }
}
